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