// Wait for the document to load before executing the JavaScript code
document.addEventListener('DOMContentLoaded', function() {

    // Select the form element
    const form = document.querySelector('form');

    // Add an event listener to the form submit button
    form.addEventListener('submit', function(event) {

        // Prevent the default form submission behavior
        event.preventDefault();

        // Get the input fields and their values
        const username = document.getElementById('username').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        // Perform basic validation on the input fields
        if (username === '' || email === '' || password === '') {
            alert('Please fill in all fields.');
            return;
        }

        // Display a loading spinner while the form is being submitted
        const spinner = document.createElement('div');
        spinner.classList.add('spinner');
        form.appendChild(spinner);

        // Submit the form data to the server (not implemented in this example)
        // and handle the response
        // Here's an example response handling function:
        function handleResponse(response) {
            if (response.status === 'success') {
                window.location.href = 'register-success.html';
            } else {
                alert('There was an error processing your request. Please try again later.');
            }
            // Remove the loading spinner
            spinner.remove();
        }

    });

});
