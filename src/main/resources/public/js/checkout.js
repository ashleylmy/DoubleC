$(document).ready(function () {

    $("#checkout-form").on("submit", function (event) {

        event.preventDefault();

        var cardNumber = $('#card-number').val(),
            cardHolderName = $('#card-name').val(),
            address = $('#address').val()+", "+ $('#city').val()+","+ $('#state').val()+" "+ $('#zip').val();


        $.ajax({
            type: "POST",
            url: "/checkout",
            data: {"cardNumber": cardNumber, "cardHolderName": cardHolderName, "address": address},
            dataType: 'json',
            success: function (response) {
                // createdorder=response
                // console.log(response);
                window.location.href = "/order/"+response.id;
            },
            error: function (error) {
                console.log("error called! " + JSON.stringify(error));
            }
        });
    })
})