$(document).ready(function(){
    showDetailArticle()

})
function showDetailArticle(){
    $.ajax({
        type: "GET",
        url: "/api/lists",
        success: function (response) {
            for (let i = 0; i < response.length; i++){

                if(response[i].id==location.search.substring(location.search.lastIndexOf("=")+1)){
                    console.log(response[i]);
                    let board = response[i];
                    let id = board.id;
                    let title = board.title;
                    let name = board.name;
                    let contents = board.contents;
                    addHTML(id,title,name,contents);
                    break;
                }else{
                    continue;
                }
            }
        }
    })
}

function addHTML(id,title,name,contents)
{
    let tempHtml = ` 
                <tr>
                    <th class="title wide">글제목</th>
                    // <td><input type="text" name="title" id="title" required="requiredw" value="${title}"></td>
                </tr>
                <tr >
                    <th class="name wide">작성자</th>
                    // <td><div name="name" id="name">${name}</div></td>
                </tr>
                <tr>
                    <th class="content wide">글내용</th>
                    // <td><textarea rows="15" cols="40" name="content" required="required" id="content">${contents}</textarea></td>
                </tr>`;
    $('#detailTable').append(tempHtml)
}

function modifyPost(event)
{
    event.preventDefault();
    //작성한 정보 불러오기
    let title = $('#title').val();
    let name = $('#name').text();
    let content = $('#content').val();
    let a=location.search.substring(location.search.lastIndexOf("=")+1)
    console.log(a)
    let data = {'writer':name,'title':title, 'contents':content};
    console.log(data)
    $.ajax({
        type:"PUT",
        url:`/api/lists/${a}`,
        contentType:"application/json",
        data:JSON.stringify(data),
        success:function(response){
            alert("게시글이 성공적으로 수정되었습니다.");
            window.location.href="index.html";
        }
    });
}