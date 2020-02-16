function dynInputDuration(cbox) {
  if (cbox.checked) {
    var input = document.createElement("input");
    input.type = "number";
    input.name = "duration";
    input.min = "1";
    input.style.width = "50px";
    input.style.height = "40px";
    input.required;
    input.style.fontSize = "22px";
    input.value = "1";
    var label = document.createElement("label");
    label.id = cbox.name;
    label.appendChild(input);
    document.getElementById("durationTime").appendChild(label);
  } else {
    document.getElementById(cbox.name).remove();
  }
}

function dynInputOutbound(cbox) {
  if (cbox.checked) {
    var label1 = document.createElement("label");
    label1.innerText = "From:";
    label1.style.fontSize = "20px";
    var input1 = document.createElement("input");
    input1.type = "time";
    input1.id = "input1";
    input1.name = "outboundTimeFrom";
    input1.step = "900";
    input1.style.marginRight = "15px";
    input1.style.marginLeft = "5px";
    input1.style.width = "32%";
    input1.style.height = "40px";
    input1.style.fontSize = "22px";
    input1.required;
    input1.value = "12:00";
    var label2 = document.createElement("label");
    label2.innerText = "To:";
    label2.style.fontSize = "20px";
    var input2 = document.createElement("input");
    input2.type = "time";
    input2.style.marginLeft = "5px";
    input2.style.width = "32%";
    input2.name = "outboundTimeTo";
    input2.step = "900";
    input2.style.height = "40px";
    input2.style.fontSize = "22px";
    input2.value = "20:00";
    input2.required;
    var label = document.createElement("label");
    label.id = cbox.name;
    label.appendChild(label1);
    label.appendChild(input1);
    label.appendChild(label2);
    label.appendChild(input2);
    document.getElementById("outboundTime").appendChild(label);
  } else {
    document.getElementById(cbox.name).remove();
  }
}

$(function () {
  $(document).ready(function () {
    $("#dupa").click(function (event) {
      alert($(this).attr('data-id-client'));
      $.ajax({
        url: '/filter/' + $(this).attr('data-id-client'),
        type: "GET",
        success: function () {

          location.replace("/searchList");
        },
        error: function(){

        }
      })
    })
  })
});





