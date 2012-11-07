<jsp:include page="header.jsp"/>
<!-- Main hero unit for a primary marketing message or call to action -->
<div class="hero-unit">
    <h1>Hello, CDI!</h1>

    <p>This is an application that shows you the basic working of CDI. Explore the source code to know more!</p>

    <p>Below, you will find a table that is populated using a REST call to the webservice.</p>

    <p>You can add new entries, and delete single entries.</p>

    <p>The put functionality is a little bit off, considering "PUT" should create a new resource. We will just create a
        new entry.</p>
</div>
<div class="span6 offset3">
    <table>
        <thead>
        <tr>
            <th>Message</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody data-bind="foreach: messages">
        <tr>
            <td><input data-bind="value: message"/></td>
            <td><a href="#" data-bind="click: $root.removeMessage"><i class="icon-remove"></i></a></td>
        </tr>
        </tbody>
    </table>

</div>
<jsp:include page="footer.jsp"/>
