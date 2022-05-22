const form = document.getElementsByTagName("form")[0];

const services = document.getElementById('servicesCheckbox');
const days = document.getElementById('days').innerText.replace(/[^0-9]/g, '');

const startPrice = document.querySelector(".actual-price").innerText.replace(/[^0-9.]/g, '');
const priceElement = document.querySelector(".actual-price");
let price = startPrice * parseFloat(days);
(function() {
    priceElement.innerText = `${(price).toFixed(2)}€`;
})();
form.addEventListener("click", (e) =>{
    const target = e.target;
    let price = parseFloat(priceElement.innerText);
    if(String(target).toLowerCase().includes("input")) {
        const clickedCheckboxValue = parseFloat(target.value);
        priceElement.innerText = target.checked ? `${(price + clickedCheckboxValue).toFixed(2)}€`
            : `${(price - clickedCheckboxValue).toFixed(2)}€`;
    }
})
