var working = "";

function loadAll(workingDir) {
    if (workingDir==null) workingDir = '';
    var service = workingDir + '/book/all';
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            printAll(this.responseText, workingDir);
        }
    };

     xmlHttp.open("GET", service, true) ;
     xmlHttp.send();
}

function printAll(rawJson, workingDir) {
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
                '</th></tr></tbody></table></div><div class="col-sm-8 pull-right">' +
                '<button type="button" class="btn-sm btn-primary">Update</button><br>' +
                '<button type="button" class="btn-sm btn-danger">Delete</button></div></div>';
    }
    document.getElementById("bookWell").innerHTML = out;
}

function saveNewBook() {
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

    alert(json);
}
