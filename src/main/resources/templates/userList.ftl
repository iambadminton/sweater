<#import "parts/common.ftl" as c>
<@c.page>

    List of users
    <#list users as user>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Role</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
            </tbody>
        </table>
    </#list>
</@c.page>