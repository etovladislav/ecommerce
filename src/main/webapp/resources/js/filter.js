
function filterProduct() {
    var filter = $("#filter").val();
    window.location.href = "/products?filter=" + filter;

}