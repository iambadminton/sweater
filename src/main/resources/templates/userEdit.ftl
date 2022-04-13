<#import "parts/common.ftl" as c>
<@c.page>
    User Editor

    <form action="/user" method="post">
        <input type="hidden" name="userID" value="${user.id}">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input type="text" name="username" value="${user.username}">
        <#list roles as role>
            <div>
                <label>
                    <input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}
                </label>
            </div>
        <#else >
            Roles not found
        </#list>
        <button type="submit">Save</button>
    </form>
</@c.page>