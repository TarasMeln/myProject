<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Taras--%>
<%--  Date: 14.02.2021--%>
<%--  Time: 01:44--%>
<%--  To change this template use File | Settings | File Templates.--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exhibition we have</title>
    <link rel="stylesheet" href="resources/css/exhibition-style.css">
    <script type="text/javascript">
        window.onload = function () {
            var b = document.getElementById("b");
            b.disabled = !${Role};
        }

    </script>
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Exhibitions</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <form action="exhibition" method="get" name="command=CHECK">
            <input id="b" type="submit" value="Add Exhibition"
                   onclick="window.location.href='add-exhibition-form.jsp';return false;"
                   class="add-exhibition-button"
            />
        </form>

        <form action="exhibition" method="get">
            <p><select size="3" multiple name="command">
                <option disabled selected value>Sort by</option>
                <option value="SORT_BY_DATE">Date</option>
                <option value="SORT_BY_THEME">Theme</option>
                <option value="SORT_BY_PRICE">Price</option>
            </select></p>
            <p><input type="submit" value="Submit"></p>
        </form>

        <table>
            <tr>
                <th>Theme</th>
                <th>Hall</th>
                <th>Date</th>
                <th>Ticket price</th>
                <th>Action</th>
                <th></th>


            </tr>
            <c:forEach var="tempExhibition" items="${Exhibition_List}">


                <c:url var="tempLink" value="exhibition">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="exhibitionId" value="${tempExhibition.getId()}"/>
                </c:url>

                <c:url var="deleteLink" value="exhibition">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="exhibitionId" value="${tempExhibition.getId()}"/>
                </c:url>
                <c:url var="BuyLink" value="exhibition">
                    <c:param name="command" value="BUY"/>
                    <c:param name="exhibitionId" value="${tempExhibition.getId()}"/>
                </c:url>
                <c:url var="StatisticsLink" value="exhibition">
                    <c:param name="command" value="STATISTICS"/>
                    <c:param name="exhibitionId" value="${tempExhibition.getId()}"/>
                </c:url>

                <tr>
                    <td> ${tempExhibition.getTheme()}</td>
                    <td> ${tempExhibition.getHall()}</td>
                    <td> ${tempExhibition.getDate()}</td>
                    <td> ${tempExhibition.getTicketPrice()}</td>

<%--                    action="exhibition"  name="command=CHECK"--%>
                    <td>
                        <form action="${tempLink}" method="get">
                            <input type="submit" value="Update" />
                        </form>
<%--                        <a href="  " > Update</a>--%>
                        |
                        <a href="${deleteLink}"
                           onclick="if(!(confirm('Are you sure you want to delete this exhibition?'))) return false;">Delete</a>
                        |
                        <a href="${BuyLink}"
                           onclick="if(!(confirm('Do you think you can afford this ticket?'))) return false;">Buy</a>
                        |
                        <a href="${StatisticsLink}">Statistics</a>


                    </td>
                        <%--                    <td>--%>
                        <%--                        <a href="${tempLink}">Update</a>--%>
                        <%--                        |--%>
                        <%--                        <a href="${deleteLink}"--%>
                        <%--                           onclick="if(!(confirm('Are you sure you want to delete this exhibition?'))) return false;">Delete</a>--%>
                        <%--                        |--%>
                        <%--                        <a href="${BuyLink}"--%>
                        <%--                           onclick="if(!(confirm('Do you think you can afford this ticket?'))) return false;">Buy</a>--%>
                        <%--                        |--%>
                        <%--                        <a href="${StatisticsLink}">Statistics</a>--%>

                        <%--                    </td>--%>
                </tr>

            </c:forEach>
        </table>

        <a href="index.html">Back to login</a>
    </div>
</div>
</body>
</html>
