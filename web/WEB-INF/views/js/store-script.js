var working;

// Call books from db
function loadAll() {
    if (working==null) working = '';
    var service = working + '/book/all';
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            printAll(this.responseText);
        }
    };

     xmlHttp.open("GET", service, true) ;
     xmlHttp.send();
}

// Refresh boot out puts
function refresh() {
    document.getElementById("bookWell").innerHTML = '';
    loadAll();
}

// Print all books
function printAll(rawJson) {

    if (working==null) working = '';
    var books = JSON.parse(rawJson);
    var out = "";
    var i;
    for (i = 0; i < books.length; i++) {
        out += '<div class="panel panel-default"> <div class="panel-body"> <h4>'
                + books[i].title + '</h4><p>'
                + books[i].description +
                '<br> <div class="row"><div class="col-sm-4"><table class="table"><tbody><tr><th>Pages</th><th>'
                + books[i].pages + '</th></tr><tr><th>Price</th><th>'
                + books[i].price + '</th></tr><tr><th>ISBN</th><th>'
                + books[i].isbn +
                '</th></tr></tbody></table></div><a class="col-sm-8 pull-right">' +
                '<a href="' + working + '/update?bookId='
                + books[i].id + '"><button type="button" class="btn-sm btn-primary">Update</button></a>' +
                '<button onclick="removeBook('
                + books[i].id + ')" type="button" class="btn-sm btn-danger">Delete</button></div></div></div></div>';
    }
    document.getElementById("bookWell").innerHTML = out;
}

// Saving new book in DB
function saveNewBook() {

    if (working==null) working = '';
    var service = working + '/book/add';
    var digitPat = /\d+/;
    var floatPat = /\d+\.\d{0}/;

    var title = document.getElementById("title").value;
    var desc = document.getElementById("desc").value;
    var isbn = document.getElementById("isbn").value;

    var raw = document.getElementById("pages").value;
    var pages;
    if (digitPat.test(raw)) {
        pages = parseInt(raw);
    } else {
        alert('Pages must be number');
        return;
    }

    var price;
    raw = document.getElementById("price").value;
    if (floatPat.test(raw)) {
        price = parseFloat(raw);
    } else {
        alert('Price must be real');
        return;
    }
    var Book = {
        "id":null,
        "title":title,
        "price":price,
        "description":desc,
        "isbn":isbn,
        "pages":pages
    };

    var json = JSON.stringify(Book);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            okStateNote(this.responseText);
        } else {
            errorState(this.responseText);
        }
    };

    xmlHttp.open("POST", service, true);
    xmlHttp.send(json);
}

// Removing book from db
function removeBook(bookId) {

    if (working==null) working = '';
    var service = working + '/book/remove';
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            refresh();
            okStateNote(this.responseText);
        } else {
            errorState(this.responseText);
        }
    };

    xmlHttp.open("POST", service, true);
    xmlHttp.send(bookId);
}

function setWorkingDir(workingDir) {
    if (workingDir == null) working = '';
    else working = workingDir;
}

function errorState(msg) {
    document.getElementById("warningsArea").innerHTML = '<div class="alert alert-warning">' + msg + '</div>';
}

function okStateNote(msg) {
    document.getElementById("warningsArea").innerHTML = '<div class="alert alert-success">' + msg + '</div>';
}
