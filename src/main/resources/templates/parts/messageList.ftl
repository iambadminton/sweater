<#include "security.ftl">
<#import "pager.ftl" as p>

<@p.pager url page/>
    <div class="row row-cols-3">

        <#list page.content as message>
            <div class="card my-3 ms-3 me-3" style="width: 18rem;" data-id="${message.id}">
                <div>
                    <#if message.filename??>
                        <img class="card-img-top" src="/img/${message.filename}"/>
                    </#if>
                </div>
                <b>${message.id}</b>
                <div class="m-2">
                    <span>${message.text}</span>
                    <i>#${message.tag}</i>
                </div>
                <div class="card-footer">
                    <a href="/user-messages/${message.author.id}">${message.authorName}</a>
                    <#if message.author.id == currentUserId>
                        <a class="btn btn-primary"
                           href="/user-messages/${message.author.id}?message=${message.id}">Edit</a>
                    </#if>
                </div>


            </div>

        </#list>
    </div>
<@p.pager url page/>