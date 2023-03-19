// Wait for the document to load before executing the JavaScript code
document.addEventListener('DOMContentLoaded', function() {

    // Select the slideshow container
    const slideshow = document.querySelector('.slideshow');

    // Select the slideshow images
    const images = slideshow.querySelectorAll('img');

    // Set the initial image index and interval duration
    let index = 0;
    const intervalDuration = 5000;

    // Start the slideshow
    setInterval(function() {
        // Hide the current image
        images[index].classList.remove('active');
        // Increment the image index
        index++;
        // Reset the image index if we've reached the end of the slideshow
        if (index >= images.length) {
            index = 0;
        }
        // Show the next image
        images[index].classList.add('active');
    }, intervalDuration);

});
