package com.example.agency.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Spring Boot ile kullanıldığında, bu anotasyon HTTP 404 Not Found yanıtı döndürmeyi sağlar
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException { // RuntimeException kullanmak daha yaygındır

    private static final long serialVersionUID = 1L; // Seri numarası (isteğe bağlı)

    private String resourceName; // Örneğin: "TimelineEvent"
    private String fieldName;    // Örneğin: "id"
    private Object fieldValue;   // Örneğin: 123L

    // Standart yapılandırıcı: Bir mesaj ile temel istisnayı çağırır
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Kaynak Bulunamadı hatasını özel olarak yapılandıran yapılandırıcı.
     * * @param resourceName Hangi kaynak bulunamadı (Örn: "TimelineEvent")
     * @param fieldName Hangi alan ile arama yapıldı (Örn: "id")
     * @param fieldValue Alanın değeri (Örn: 123L)
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        // Hata mesajını oluşturur
        super(String.format("%s, %s : '%s' ile bulunamadı", resourceName, fieldName, fieldValue));

        // Alan değerlerini saklar
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    // --- Getter Metotları ---

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}