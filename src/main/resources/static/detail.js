$(document).ready(function(){
    showDetailArticle()


})
function showDetailArticle(){
    $.ajax({
        type: "GET",
        url: "/api/lists",
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                console.log(response[i].id)
                let a = location.search.substring(location.search.lastIndexOf("=")+1);
                if(response[i].id==location.search.substring(location.search.lastIndexOf("=")+1)){
                    let board = response[i];
                    let id = board.id;
                    let title = board.title;
                    let name = board.name;
                    let contents = board.contents;
                    let createDate = board.createdAt;
                    addHTML(id,title,name,contents,createDate,a);
                    break;
                }else{
                    continue;
                }
            }
        }
    })
}
function addHTML(id,title,name,contents,createDate,a){
    let tempHtml = ` 
                <tr>
                    <th style="background-color: darkcyan; color: whitesmoke;" class="title wide">글제목</th>
                    <td style="border: 2px solid black;"><div name="title">${title}</div></td>
                </tr>
                <tr>
                    <th style="background-color: darkcyan; color: whitesmoke;" class="name wide">작성자</th>
                    <td style="border: 2px solid black;"><div name="name">${name}</div></td>
                </tr>
                <tr >
                    <th style="background-color: darkcyan; color: whitesmoke;" class="createdAt wide">작성날짜</th>
                    <td style="border: 2px solid black;"><div name="createdAt">${createDate}</div></td>
                </tr>

                <tr>
                    <th style="background-color: darkcyan; color: whitesmoke;" class="content wide">글내용</th>
                    <td style="border: 2px solid black;"><div name="content" style="width: 200px; height: 200px; margin: 0 auto;">${contents}</div></td>
                </tr>`;
    $('#detailTable').append(tempHtml)

    let tempHtmlTwo = `
        <a href="modify.html?id=${a}" style="text-decoration: none">수정하기</a>
        <a href="/index.html" onclick="deletePost(event)" style="text-decoration: none;">삭제하기</a>
        <a href="index.html" style="text-decoration: none">뒤로가기</a>`;
    $('#commandCell').append(tempHtmlTwo);
}

function deletePost(event)
{
    event.preventDefault();
    let a=location.search.substring(location.search.lastIndexOf("=")+1)
    $.ajax({
        type:"DELETE",
        url:`/api/lists/${a}`,
        success:function(response){
            alert('삭제에 성공했습니다.')
            window.location.href="index.html";

        }
    })
}