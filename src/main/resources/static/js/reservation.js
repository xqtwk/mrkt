const form = document.getElementsByTagName("form")[0];

const services = document.getElementById('servicesCheckbox');
const meals = document.getElementById('mealsCheckbox');

form.addEventListener("click", (e) =>{
    const target = e.target;
    const priceElement = document.querySelector(".actual-price");
    let price = parseFloat(priceElement.innerText);
    if(String(target).toLowerCase().includes("input")) {
        const clickedCheckboxValue = parseFloat(target.value);
        priceElement.innerText = target.checked ? `${(price + clickedCheckboxValue).toFixed(2)}€`
            : `${(price - clickedCheckboxValue).toFixed(2)}€`;
    }
})
/*
booking.meals.addEventListener("change", printF1func);
booking.services.addEventListener("change", printF2func);
var printF1 = document.getElementById('total');
function printF1func() {
    if (booking.meals.checked) {
        if (isNaN(parseFloat(printF1.innerHTML))){
            printF1.innerHTML += booking.meals.value;
        } else {
            printF1.innerHTML += parseFloat(printF1.innerHTML) + booking.meals.value;
        }
} else {                                                                   // template for all
        if (isNaN(parseFloat(printF1.innerHTML))){
            printF1.innerHTML -= printF1.innerHTML;
        } else {
            printF1.innerHTML -= parseFloat(printF1.innerHTML) - booking.meals.value;
        }
    }
};
function printF2func() {
    if (booking.services.checked) {
        printF1.innerHTML += booking.services.value;
    } else {
        printF1.innerHTML -= booking.services.value;;
    }
};*/