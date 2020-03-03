$.get("/user", function (data) {
    $("#user").html(data.userAuthentication.details.email);
    var sendObj = {};
    sendObj.id = data.userAuthentication.details.id;
    sendObj.email = data.userAuthentication.details.email;
      $.ajax({
        url: "/userManage/",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data:JSON.stringify(sendObj),
        success: function () {
        }
      });

    $(".unauthenticated").hide();
    $(".authenticated").show();
    $(".loginButton").hide();
    $(".logOutButton").show();
    $(".favourite").show();
});


var logout = function () {
  $.post("/logout", function () {
    $("#user").html('');
    $(".unauthenticated").show();
    $(".authenticated").hide();
    $(".loginButton").show();
    $(".logOutButton").hide();
    $(".favourite").hide();
  });
  return true;
};

if (window.location.hash === '#_=_') {
  history.replaceState
      ? history.replaceState(null, null, window.location.href.split('#')[0])
      : window.location.hash = '';
}

