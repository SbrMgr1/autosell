$(function () {
    $(".accept-btn").on("click",function (e) {
        e.preventDefault();
        $.ajax({
            url:"/administration/users/accept/"+$(this).data("id"),
            type:"post",
            contentType:'application/json',
            dataType:"json",
            data:JSON.stringify([])
        }).done(function (resp) {

        })
    })
});