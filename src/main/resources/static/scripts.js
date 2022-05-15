const arrivalPicker = document.querySelector('#arrival-date');
const departurePicker = document.querySelector('#departure-date');
flatpickr(arrivalPicker, {"locale": "lt", minDate:new Date().toISOString().slice(0, 10), "allowInput": true, disableMobile: "true"});
flatpickr(departurePicker, {"locale": "lt", minDate:new Date().toISOString().slice(0, 10), "allowInput": true, disableMobile: "true"});
