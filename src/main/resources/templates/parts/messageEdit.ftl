<a class="btn btn-primary mb-3" data-bs-toggle="collapse" href="#newMessage" role="button" aria-expanded="false"
   aria-controls="newMessage">
    Message editor
</a>

<div class="collapse <#if message??>show</#if>" id="newMessage">
    <form method="post" enctype="multipart/form-data">
        <div class="row mb-3">
            <div class="col-6">
                <input class="form-control ${(textError??)?string('is-invalid', '')}" type="text"
                       value="<#if message??>${message.text}</#if>"
                       name="text" placeholder="Введите сообщение"/>
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
            </div>
            <div class="col-6">
                <input class="form-control" type="text" name="tag"
                       value="<#if message??>${message.tag}</#if>" placeholder="Тэг">
                <#if tagError??>
                    <div class="invalid-feedback">
                        ${tagError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="col-12 mb-3">
            <input class="form-control" type="file" name="file">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="id" value="<#if message??>${message.id}</#if>"/>
        <button class="btn btn-primary mb-3" type="submit">Save message</button>
    </form>
</div>