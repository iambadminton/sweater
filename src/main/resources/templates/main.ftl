<#import "parts/common.ftl" as c>


<@c.page>
    <div class="input-group mb-3">
        <form method="get" action="/main" class="row row-cols-lg-auto">
            <div><input type="text" class="form-control" name="filter" value="${filter?if_exists}"></div>
            <button type="submit" class="btn btn-primary ">Найти</button>
        </form>
    </div>

    <a class="btn btn-primary mb-3" data-bs-toggle="collapse" href="#newMessage" role="button" aria-expanded="false"
       aria-controls="newMessage">
        Add new message
    </a>
    <div class="collapse" id="newMessage">
        <form method="post" enctype="multipart/form-data">
            <div class="row mb-3">
                <div class="col-6">
                    <input class="form-control" type="text" name="text" placeholder="Введите сообщение"/>
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" name="tag" placeholder="Тэг">
                </div>
            </div>
            <div class="col-12 mb-3">
                <input class="form-control" type="file" name="file">
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-primary mb-3" type="submit">Добавить</button>
        </form>
    </div>


    <div class="row row-cols-3">
        <#list messages as message>
            <div class="card my-3 ms-3 me-3" style="width: 18rem;">
                <div>
                    <#if message.filename??>
                        <img class="card-img-top" src="/img/${message.filename}">
                    </#if>
                </div>
                <b>${message.id}</b>
                <div class="m-2">
                    <span>${message.text}</span>
                    <i>${message.tag}</i>
                </div>
                <div class="card-footer">
                    ${message.authorName}
                </div>


            </div>

        </#list>
    </div>
</@c.page>
