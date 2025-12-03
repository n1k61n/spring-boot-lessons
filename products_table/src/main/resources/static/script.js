   function showSection(sectionId) {
        document.getElementById('fullUpdateForm').classList.add('hidden');

        document.querySelectorAll('.section').forEach(el => el.classList.add('hidden'));
        document.getElementById(sectionId).classList.remove('hidden');
    }

    async function loadAllProducts() {
        const container = document.getElementById('productsList');
        const button = container.previousElementSibling;

        button.disabled = true;
        button.textContent = 'Loading...';
        container.innerHTML = '<p>Loading products...</p>';

        try {
            const res = await fetch('/api/products');
            if (!res.ok) throw new Error('Failed: ' + res.status);

            const products = await res.json();
            if (products.length === 0) {
                container.innerHTML = '<p>No products found.</p>';
                return;
            }

            let html = '<table><thead><tr>';
            html += '<th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Stock</th>';
            html += '</tr></thead><tbody>';

            products.forEach(p => {
                html += `<tr>
                    <td>${p.id || ''}</td>
                    <td>${p.name || ''}</td>
                    <td>${p.category || '-'}</td>
                    <td>$${Number(p.price).toFixed(2)}</td>
                    <td>${p.stock ?? '-'}</td>
                </tr>`;
            });

            html += '</tbody></table>';
            container.innerHTML = html;
        } catch (e) {
            container.innerHTML = `<p style="color:red">Error: ${e.message}</p>`;
            console.error(e);
        } finally {
            button.disabled = false;
            button.textContent = 'Load Products';
        }
    }

    // FIX: Changed method to 'PUT' after PATCH and POST failed with 405
    async function updatePrice() {
        const id = document.getElementById('updateId').value.trim();
        const newPrice = document.getElementById('newPrice').value.trim();

        if (!id || !newPrice) {
            alert('Please enter both Product ID and the New Price.');
            return;
        }

        const priceValue = parseFloat(newPrice);
        if (isNaN(priceValue) || priceValue < 0) {
            alert('Please enter a valid price.');
            return;
        }

        const productUpdate = { price: priceValue };

        if (!confirm(`Update price for product ID ${id} to $${priceValue.toFixed(2)}?`)) return;

        try {
            const res = await fetch(`/api/products/${id}`, {
                method: 'PUT', // Now using PUT
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(productUpdate)
            });

            if (res.status === 404) return alert('Product not found!');
            if (!res.ok) throw new Error(await res.text() || res.status);

            alert('Price updated successfully!');
            document.getElementById('updateId').value = '';
            document.getElementById('newPrice').value = '';

            if (!document.getElementById('showAllProducts').classList.contains('hidden')) {
                loadAllProducts();
            }
        } catch (err) {
            alert('Error updating price: ' + err.message);
            console.error(err);
        }
    }


    async function addProduct() {
        const name = document.getElementById('addName').value.trim();
        const price = document.getElementById('addPrice').value.trim();
        const category = document.getElementById('addCategory').value.trim();
        const stock = document.getElementById('addStock').value.trim();

        if (!name || !price) return alert('Name and Price are required!');

        const product = {
            name,
            price: parseFloat(price),
            category: category || null,
            stock: stock ? parseInt(stock, 10) : null
        };

        try {
            const res = await fetch('/api/products', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(product)
            });

            if (!res.ok) throw new Error(await res.text());

            alert('Product added successfully!');
            document.getElementById('addName').value = '';
            document.getElementById('addPrice').value = '';
            document.getElementById('addCategory').value = '';
            document.getElementById('addStock').value = '';

            if (!document.getElementById('showAllProducts').classList.contains('hidden')) {
                loadAllProducts();
            }
        } catch (e) {
            alert('Error: ' + e.message);
        }
    }

    async function deleteProduct() {
        const id = document.getElementById('deleteId').value.trim();
        if (!id) return alert('Enter ID');
        if (!confirm(`Delete product ID ${id}?`)) return;

        try {
            const res = await fetch(`/api/products/${id}`, { method: 'DELETE' });
            if (!res.ok) throw new Error(await res.text() || res.status);

            alert('Deleted successfully!');
            document.getElementById('deleteId').value = '';

            if (!document.getElementById('showAllProducts').classList.contains('hidden')) {
                loadAllProducts();
            }
        } catch (e) {
            alert('Delete failed: ' + e.message);
        }
    }

    async function findProductById() {
        const id = document.getElementById('searchId').value.trim();
        const result = document.getElementById('searchResultId');
        if (!id) return alert('Enter ID');

        result.innerHTML = '<p>Searching...</p>';

        try {
            const res = await fetch(`/api/products/${id}`);
            if (res.status === 404) {
                result.innerHTML = '<p style="color:#999">Product not found</p>';
                return;
            }
            if (!res.ok) throw new Error(await res.text());

            const p = await res.json();

            result.innerHTML = `
                <table><thead><tr><th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Stock</th><th>Action</th></tr></thead>
                    <tbody>
                        <tr>
                            <td>${p.id || ''}</td>
                            <td>${p.name || ''}</td>
                            <td>${p.category || '-'}</td>
                            <td>$${Number(p.price).toFixed(2)}</td>
                            <td>${p.stock ?? '-'}</td>
                            <td><button onclick="editProductFull(${p.id})">Edit</button></td>
                        </tr>
                    </tbody>
                </table>
            `;
        } catch (e) {
            result.innerHTML = `<p style="color:red">Error: ${e.message}</p>`;
            console.error(e);
        }
    }

    async function editProductFull(productId) {
        try {
            const res = await fetch(`/api/products/${productId}`);
            if (!res.ok) {
                if (res.status === 404) return alert('Product not found!');
                throw new Error('Server error');
            }

            const product = await res.json();

            document.getElementById('editProductId').value       = product.id;
            document.getElementById('editProductName').value     = product.name || '';
            document.getElementById('editProductPrice').value    = product.price || '';
            document.getElementById('editProductCategory').value = product.category || '';
            document.getElementById('editProductStock').value    = product.stock ?? '';

            document.getElementById('fullUpdateForm').classList.remove('hidden');

            document.getElementById('findById').classList.add('hidden');

            document.getElementById('editProductName').focus();

        } catch (err) {
            alert('Error loading product for edit: ' + err.message);
            console.error(err);
        }
    }

    async function findProductByName() {
        const name = document.getElementById('searchName').value.trim();
        const result = document.getElementById('searchResultName');
        if (!name) return alert('Enter name');

        result.innerHTML = '<p>Searching...</p>';
        try {
            const res = await fetch(`/api/products/search?name=${encodeURIComponent(name)}`);
            if (!res.ok) throw new Error(await res.text());

            const products = await res.json();
            if (!products.length) return result.innerHTML = '<p>No products found</p>';

            let html = '<table><thead><tr><th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Stock</th></tr></thead><tbody>';
            products.forEach(p => {
                html += `<tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.category || '-'}</td>
                    <td>$${Number(p.price).toFixed(2)}</td>
                    <td>${p.stock ?? '-'}</td>
                </tr>`;
            });
            html += '</tbody></table>';
            result.innerHTML = html;
        } catch (e) {
            result.innerHTML = `<p style="color:red">Error: ${e.message}</p>`;
        }
    }

    async function saveFullProductUpdate() {
        const id       = document.getElementById('editProductId').value;
        const name     = document.getElementById('editProductName').value.trim();
        const price    = document.getElementById('editProductPrice').value.trim();
        const category = document.getElementById('editProductCategory').value.trim();
        const stock    = document.getElementById('editProductStock').value.trim();

        if (!name || !price) {
            alert('Name and Price are required!');
            return;
        }

        if (isNaN(price) || price < 0) {
            alert('Please enter a valid price');
            return;
        }

        const updatedProduct = {
            name,
            price: parseFloat(price),
            category: category || null,
            stock: stock !== '' ? parseInt(stock, 10) : null
        };

        if (!confirm('Save changes to this product?')) return;

        try {
            const res = await fetch(`/api/products/${id}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(updatedProduct)
            });

            if (!res.ok) {
                const errorText = await res.text();
                throw new Error(errorText || 'Update failed');
            }

            alert('Product updated successfully!');
            cancelFullUpdate();

            if (!document.getElementById('showAllProducts').classList.contains('hidden')) {
                loadAllProducts();
            }

        } catch (err) {
            alert('Failed to update: ' + err.message);
            console.error(err);
        }
    }

    function cancelFullUpdate() {
        document.getElementById('fullUpdateForm').classList.add('hidden');

        document.getElementById('findById').classList.remove('hidden');

        document.getElementById('editProductId').value = '';
        document.getElementById('editProductName').value = '';
        document.getElementById('editProductPrice').value = '';
        document.getElementById('editProductCategory').value = '';
        document.getElementById('editProductStock').value = '';
    }