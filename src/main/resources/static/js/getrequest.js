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


    // select a batch of images
    function handleFileSelect(evt) {
        var files = evt.target.files; // FileList object

        // files is a FileList of File objects. List some properties.
        var output = [];
        for (var i = 0, f; f = files[i]; i++) {
            output.push('<li><strong>', escape(f.name), '</strong> (', f.type || 'n/a', ') - ',
                f.size, ' bytes, last modified: ',
                f.lastModifiedDate ? f.lastModifiedDate.toLocaleDateString() : 'n/a',
                '</li>');
        }
        document.getElementById('list').innerHTML = '<ul>' + output.join('') + '</ul>';
    }

    document.getElementById('files').addEventListener('change', handleFileSelect, false);
});