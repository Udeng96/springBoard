$(document).ready(function(){
    console.log("hello world")
    showArticle();
})
function showArticle(){
    $.ajax({
        type: "GET",
        url: "/api/lists",
        success: function (response) {
            console.log("ajax response:", response);
            for (let i = 0; i < response.length; i++) {
                let board = response[i];
                console.log(board);
                let id = board.id;
                let title = board.title;
                let name = board.name;
                let contents = board.contents;
                let createDate = board.createdAt;
                addHTML(id,title,name,contents,createDate);
            }
        }
    })
}

function addHTML(id,title,name,contents,createDate)
{
    console.log("id:", id, "title:", title, "contents:", contents, 'createDate:',createDate);
    let tempHtml = ` 
                <tr>
                    <td><a href="detail.html?id=${id}"> ${title}</a></td>
                    <td>${name}</td>
                    <td>${contents}</td>
                    <td>${createDate}</td>
                </tr>`;
    $('#boards_box').append(tempHtml)
}