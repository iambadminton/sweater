<#include "security.ftl">
<#import "pager.ftl" as p>

<@p.pager url page/>
<#--<div class="row row-cols-3">-->
<div class="row row-cols-1 row-cols-md-3 g-4">

    <#list page.content as message>
        <div class="card mx-3 px-0" style="width: 18rem;" data-id="${message.id}">
            <div class="card-body">
                <div>
                    <#if message.filename??>
                        <img class="card-img-top" src="/img/${message.filename}"/>
                    </#if>
                </div>
                <b>${message.id}</b>
                <div class="m-2">
                    <span>${message.text}</span><br/>
                    <i>#${message.tag}</i>
                </div>

            </div>
            <div class="card-footer text-muted container">
                <div class="row">
                    <a class="col align-items-center"
                       href="/user-messages/${message.author.id}">${message.authorName}</a>
                    <a class="col align-items-center" href="/messages/${message.id}/like">
                        <#if message.meLiked>
                            <i class="fa-solid fa-heart"></i>
                        <#else >
                            <i class="fa-regular fa-heart"></i>
                        </#if>
                        ${message.likes}


                    </a>
                    <#if message.author.id == currentUserId>
                        <a class="col btn btn-primary"
                           href="/user-messages/${message.author.id}?message=${message.id}">Edit</a>
                    </#if>
                </div>
            </div>


        </div>


    </#list>
</div>
<@p.pager url page/>