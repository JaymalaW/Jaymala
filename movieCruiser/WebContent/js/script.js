function validateForm() {
    
    var title = document.forms["editMovieStatus"]["title"].value;
    if (title == ""){
        alert("Title is required");
        return false;
    }

    var titlelength = title.length;
    if(titlelength < 2 || titlelength >100){
        alert("Title should have 2 to 100 characters");
        return false;
    }

    var price = document.forms["editMovieStatus"]["gross"].value;
    if(isNaN(price)){
        alert("Box Office (Gross) has to be a number");
        return false;
    }

    if(price == ""){
        alert("Box Office (Gross) value is required");
        return false;
    }

    var dateOfLaunch = document.forms["editMovieStatus"]["dateOfLaunch"].value;
    if(dateOfLaunch == ""){
        alert("Date of Launch is required");
        return false;
    }

    if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/)){
        alert("Incorrect date format. Expected format (dd/mm/yyyy)");
        return false;
    }

    var generValue = document.forms["editMovieStatus"]["genre"].value;
    if(generValue == 0){
        alert("Select one genre");
        return false;
    }

}