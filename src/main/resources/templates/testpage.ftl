<#import "parts/coomon.ftl" as c>

<@c.page>
    <#if clients??>
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col" class="text-center">name</th>
            </tr>
            </thead>
            <tbody>
            <#list clients as client>
                <tr>
                    <th scope="row">${client.id}</th>
                    <td class="text-center">${client.name}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
</@c.page>