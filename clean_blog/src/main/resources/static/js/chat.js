// src/main/resources/static/js/chat.js

var stompClient = null;
var username = null;

// Получаем элементы DOM
var usernamePage = document.querySelector('#username-page'); // Контейнер ввода имени
var usernameForm = document.querySelector('#usernameForm');

var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#messageInput');
var messageArea = document.querySelector('#messageArea'); // Список сообщений (UL)

// *** Элементы для управления ВИДЖЕТОМ ***
var chatWindow = document.querySelector('#chat-page');    // <--- Весь блок чата, который мы открываем/закрываем
var chatArea = document.querySelector('#chat-area');      // <--- Контейнер с UL и формой отправки сообщения
var chatToggler = document.querySelector('.chat-toggler');
var closeBtn = document.querySelector('.close-btn');

// Функция переключения видимости всего окна чата
function toggleChat() {
    chatWindow.classList.toggle('hidden');
}

// Обработчики событий для открытия/закрытия виджета
chatToggler.addEventListener('click', toggleChat, true);
closeBtn.addEventListener('click', toggleChat, true);


// 1. Обработка ввода имени и запуск подключения
usernameForm.addEventListener('submit', connect, true);

function connect(event) {
    event.preventDefault();

    username = document.querySelector('#name').value.trim();

    if(username) {
        // Подключаемся к WebSocket
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
}

function onConnected() {
    // Подписываемся на публичный канал
    stompClient.subscribe('/topic/public', onMessageReceived);

    // После успешного подключения:
    // 1. Скрываем форму ввода имени
    usernamePage.classList.add('hidden');
    // 2. Показываем область чата
    chatArea.classList.remove('hidden');

    // Отправляем сообщение о подключении
    stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    );
}

function onError(error) {
    console.error('Не удалось подключиться к WebSocket: ' + error);
    alert('Не удалось подключиться к чату. Попробуйте позже.');
}

// 2. Обработка отправки сообщения
messageForm.addEventListener('submit', sendMessage, true);

function sendMessage(event) {
    event.preventDefault();
    var messageContent = messageInput.value.trim();

    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageContent,
            type: 'CHAT'
        };
        // Отправка сообщения на сервер
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = ''; // Очистка поля ввода
    }
}

// 3. Отображение полученного сообщения
function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var listItem = document.createElement('li');

    if(message.type === 'JOIN') {
        listItem.classList.add('event-message');
        listItem.textContent = message.sender + ' присоединился!';
    } else if (message.type === 'LEAVE') {
        listItem.classList.add('event-message');
        listItem.textContent = message.sender + ' покинул чат.';
    } else {
        // Обычное сообщение чата
        var senderElement = document.createElement('span');
        senderElement.textContent = message.sender + ': ';
        senderElement.style.fontWeight = 'bold';

        var contentElement = document.createElement('span');
        contentElement.textContent = message.content;

        listItem.appendChild(senderElement);
        listItem.appendChild(contentElement);
    }

    messageArea.appendChild(listItem);

    // Автоматическая прокрутка вниз
    messageArea.scrollTop = messageArea.scrollHeight;
}