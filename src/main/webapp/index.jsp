<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 22.02.2021
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sandas</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="stylesheet" href="resources/css/main-page-style.css">

</head>
<body>
<!--Шапка сайту-->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid" >
        <a href="#" class="navbar-brand"><img src ="resources/img/Logo7Try.png" alt="logo"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a href="/test" class="nav-link">TEST</a>
                </li>
                <li class="nav-item active">
                    <a href="/exhibition" class="nav-link">Виставки</a>
                </li>
                <li class="nav-item active">
                    <a href="index.html" class="nav-link">Головна</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">Про нас</a>
                </li>
                <li class="nav-item">
                    <a href="/user" class="nav-link">Ввійти</a>
                </li>
                <li class="nav-item">
                    <a href="/logout" class="nav-link">Вийти</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!--Слайдер зображень-->
<div class="carousel slide" data-ride="carousel" id="slides">
    <ul class="carousel-indicators">
        <li data-target="#slides" data-slide-to="0" class="active"></li>
        <li data-target="#slides" data-slide-to="1"></li>
        <li data-target="#slides" data-slide-to="2"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="resources/img/img111.png">
            <div class="carousel-caption">
                <h1 class="display-2">Sandas</h1>
                <h3>Make the world a better place </h3>
            </div>
        </div>
        <div class="carousel-item ">
            <img src="resources/img/img12.jpg">
            <div class="carousel-caption">
                <h1 class="display-2">Sandas</h1>
                <h3>Make the world a better place</h3>
            </div>
        </div>
        <div class="carousel-item ">
            <img src="resources/img/img13.jpg">
            <div class="carousel-caption">
                <h1 class="display-2">Sandas</h1>
                <h3>Make the world a better place</h3>
            </div>
        </div>
    </div>
</div>
<!--Основний блок сайту-->
<div class="container-fluid">
    <div class="row jumbotron">
        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil molestiae laborum possimus asperiores, maxime voluptatibus, cupiditate voluptatem, neque repudiandae fugiat at laboriosam ducimus aspernatur nostrum soluta officia natus porro consectetur. </p>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
            <a href="#"><button class="btn btn-success btn-lg" type="button">Читати далі</button></a>
        </div>
    </div>
</div>
<!--Блок з характеристиками-->
<div class="container-fluid">
    <div class="row text-center alert">
        <div class="col-12">
            <h1 class="display-4">Створення картини</h1>
        </div>
        <hr>
        <div class="col-12">
            <p class="lead">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quia earum, impedit expedita ex, deserunt harum. Repellat necessitatibus enim voluptates accusamus, magnam aliquid molestias aliquam dignissimos laborum placeat animi itaque facere praesentium doloremque ducimus quia. Quis autem expedita modi temporibus illum voluptatum, sint delectus quibusdam facere dolorem nobis consequuntur porro, assumenda numquam vel suscipit praesentium fuga enim nesciunt consequatur aliquam vitae?
            </p>
        </div>
    </div>
</div>

<!--Секція з зображеннями-->
<div class="container-fluid padding">
    <div class="row padding">
        <div class="offset-lg-2 col-lg-4">
            <h2>Щось про мистецтво</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id eos quas quo assumenda asperiores expedita quaerat quam dolor aut libero similique voluptate impedit, dignissimos in voluptatibus porro ducimus praesentium inventore.</p>
            <br>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id eos quas quo assumenda asperiores expedita quaerat quam dolor aut libero similique voluptate impedit, dignissimos in voluptatibus porro ducimus praesentium inventore.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id eos quas quo assumenda asperiores expedita quaerat quam dolor aut libero similique voluptate impedit, dignissimos in voluptatibus porro ducimus praesentium inventore.</p>
            <br>
            <a href="#" class="btn btn-danger">Читати далі</a>
        </div>

    </div>
</div>
<!--Блок з фіксованим зображенням-->
<figure>
    <div class="fixed-wrap">
        <div id="fixed">

        </div>
    </div>
</figure>
<!--Закрита секція-->
<div class="text-center">
    <button type="button" id="gifsBtn" class="btn btn-success" data-toggle="collapse" data-target="#gifs">Відкрити блок</button>
</div>
<div id="gifs" class="collapse">
    <div class="container-fluid padding">
        <div class="row test-center">
            <div class="col-sm-6 col-md-3">
                <img src="resources/img/1.gif" class="gif">
            </div>
            <div class="col-sm-6 col-md-3">
                <img src="resources/img/2.gif" class="gif">
            </div>
            <div class="col-sm-6 col-md-3">
                <img src="resources/img/3.gif" class="gif">
            </div>
            <div class="col-sm-6 col-md-3">
                <img src="resources/img/4.gif" class="gif">
            </div>
        </div>
    </div>
</div>
<!--Карточки з авторами відомих картин-->
<div class="container-fluid padding">
    <div class="row alert text-center">
        <div class="col-12">
            <h1 class="display-4">Автори відомих картин</h1>
        </div>
        <hr>
    </div>
</div>
<div class="container padding">
    <div class="row padding">
        <div class="col-md-4">
            <div class="card">
                <img src="resources/img/java5.png" class="card-img-top">
                <div class="card-body">
                    <h4 class="card-title">Edvard Munch</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit nemo, fugiat consequatur.</p>
                    <a href="#" class="btn btn-warning">Подивитися</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <img src="resources/img/c++.jpg" class="card-img-top">
                <div class="card-body">
                    <h4 class="card-title">Pablo Picasso</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit nemo, fugiat consequatur.</p>
                    <a href="#" class="btn btn-warning">Подивитися</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <img src="resources/img/js.jpg" class="card-img-top">
                <div class="card-body">
                    <h4 class="card-title">Leonardo di ser Piero da Vinci</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit nemo, fugiat consequatur.</p>
                    <a href="#" class="btn btn-warning">Подивитися</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!--Футер сайту-->
<footer class="container-fluid">
    <div class="container-fluid">
        <div class="row padding text-center">
            <div class="col-12">
                <h2>Наші контакти</h2>
            </div>
            <div class="col-12 social padding">
                <a href="#"><i class="fab fa-twitter"></i></a>
                <a href="#"><i class="fab fa-instagram"></i></a>
            </div>
        </div>
    </div>
</footer>
</body>
</html>

