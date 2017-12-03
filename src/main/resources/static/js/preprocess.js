$( document ).ready(function() {

    var url = window.location;

    $("#btnId").click(function(event){
        event.preventDefault();

        // Open Bootstrap Modal
        openModel();
        // Get data from Server
        ajaxGet();
    });

    // Open Bootstrap Modal
    function openModel(){
        $("#modalId").modal();
    }

    // DO GET
    function ajaxGet(){
        $.ajax({
            type : "GET",
            url : url + "/greeting",
            success: function(data){
                // fill data to Modal Body
                fillData(data);
            },
            error : function(e) {
                fillData(null);
            }
        });
    }

    function fillData(data){
        if(data!=null){
            $(".modal-body #greetingId").text(data);
        }else{
            $(".modal-body #greetingId").text("Can Not Get Data from Server!");
        }
    }

    // Get request
    $("#resizeBtnId").click(function(event){
        event.preventDefault();
        ajaxTriggerImageResizeScript();
    });

    // DO GET
    function ajaxTriggerImageResizeScript(){
        $.ajax({
            type : "GET",
            url : "api/trigger/imageResizeScript",
            success: function(result){
                $("#getResultDiv").html("<strong>Request sent</strong>");
                console.log("Success: ", result);
            },
            error : function(e) {
                $("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }

    // Get request
    $("#modelBtnId").click(function(event){
        event.preventDefault();
        ajaxTriggerModelScript();
    });

    // DO GET
    function ajaxTriggerModelScript(){
        $.ajax({
            type : "GET",
            url : "api/trigger/modelScript",
            success: function(result){
                $("#getObjResultDiv").html("<strong>Request sent. Hold on.</strong>");
                console.log("Success: ", result);
            },
            error : function(e) {
                $("#getObjResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }
});