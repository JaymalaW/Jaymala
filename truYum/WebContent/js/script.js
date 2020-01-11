function validateForm() {
    
    var title = document.forms["menuItemForm"]["name"].value;
    if (title == ""){
        alert("Title is required");
        return false;
    }

    var titlelength = title.length;
    if(titlelength < 2 || titlelength >65){
        alert("Title should have 2 to 65 characters");
        return false;
    }

    var price = document.forms["menuItemForm"]["price"].value;
    if(isNaN(price)){
        alert("Price has to be a number");
        return false;
    }

    if(price == ""){
        alert("Price is required");
        return false;
    }

    var dateOfLaunch = document.forms["menuItemForm"]["dateOfLaunch"].value;
    if(dateOfLaunch == ""){
        alert("Date of Launch is required");
        return false;
    }

    if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/)){
        alert("Incorrect date format. Expected format (dd/mm/yyyy)");
        return false;
    }

    
    var category = document.forms["menuItemForm"]["category"].value;
    if(category == 0){
        alert("Select one category");
        return false;
    }

}

