<#import "parts/common.ftl" as c>


<@c.page>
    <div class="input-group mb-3">
        <form method="get" action="/main" class="row row-cols-lg-auto">
            <div><input type="text" class="form-control" name="filter" value="${filter?if_exists}"></div>
            <button type="submit" class="btn btn-primary ">Найти</button>
        </form>
    </div>

    <#include "parts/messageEdit.ftl">

    <#include "parts/messageList.ftl">



</@c.page>
