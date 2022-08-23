form = document.getElementById('addProduct');
let url = 'http://localhost:8189/add';

async function retriveFormValue(event) {
    event.preventDefault();

    const title = form.querySelector(' [name="title"] ').value,
        price = form.querySelector(' [name="price"] ').value,
        category = form.querySelector(' [name="category"] ').value;

    const product = {
        title: title,
        price: price,
        category: category
    };
    console.log('product', product);
    try {
        const response = await fetch(url, {
            method: 'POST',
            body: JSON.stringify(product),
            headers: {
                'Content-Type': 'application/json'
            }
        });
        const json = await response.json();
        console.log('Успех:', JSON.stringify(json));
    }catch (error) {
        console.error('Ошибка:', error);
    }

}

form.addEventListener('submit', retriveFormValue);