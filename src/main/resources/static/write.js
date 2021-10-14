function writePost(event){
    event.preventDefault()
    //작성한 정보 불러오기
    let title = $('#title').val();
    let name = $('#name').val();
    let content = $('#content').val();

    let data = {'writer':name, 'title':title, 'contents':content};

    $.ajax({
        type:"POST",
        url:"/api/lists",
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(response){
            alert("게시글이 성공적으로 작성되었습니다.");
            history.go(-1);
        }
    });
}