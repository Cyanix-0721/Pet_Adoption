<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
    <base href="${basePath}">
    <script src="${basePath}/assets/js/color-modes.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>宠物领养系统后台管理</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.1/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.2.3/js/bootstrap.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.2.3/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/Mock.js/1.0.0/mock.js"></script>
    <script>MOCK = 'false'</script>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/dashboard/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link href="${basePath}/assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .b-example-divider {
            width: 100%;
            height: 3rem;
            background-color: rgba(0, 0, 0, .1);
            border: solid rgba(0, 0, 0, .15);
            border-width: 1px 0;
            box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
        }

        .b-example-vr {
            flex-shrink: 0;
            width: 1.5rem;
            height: 100vh;
        }

        .bi {
            vertical-align: -.125em;
            fill: currentColor;
        }

        .nav-scroller {
            position: relative;
            z-index: 2;
            height: 2.75rem;
            overflow-y: hidden;
        }

        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }

        .btn-bd-primary {
            --bd-violet-bg: #712cf9;
            --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

            --bs-btn-font-weight: 600;
            --bs-btn-color: var(--bs-white);
            --bs-btn-bg: var(--bd-violet-bg);
            --bs-btn-border-color: var(--bd-violet-bg);
            --bs-btn-hover-color: var(--bs-white);
            --bs-btn-hover-bg: #6528e0;
            --bs-btn-hover-border-color: #6528e0;
            --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
            --bs-btn-active-color: var(--bs-btn-hover-color);
            --bs-btn-active-bg: #5a23c8;
            --bs-btn-active-border-color: #5a23c8;
        }

        .bd-mode-toggle {
            z-index: 1500;
        }

        .bd-mode-toggle .dropdown-menu .active .bi {
            display: block !important;
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${basePath}/assets/css/dashboard.css" rel="stylesheet">
</head>
<body>

<!--theme icon start-->
<svg xmlns="http://www.w3.org/2000/svg" class="d-none">
    <symbol id="check2" viewBox="0 0 16 16">
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
    </symbol>
    <symbol id="circle-half" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
    </symbol>
    <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>
        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>
    </symbol>
    <symbol id="sun-fill" viewBox="0 0 16 16">
        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
    </symbol>
</svg>
<div class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
    <button class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center"
            id="bd-theme"
            type="button"
            aria-expanded="false"
            data-bs-toggle="dropdown"
            aria-label="Toggle theme (auto)">
        <svg class="bi my-1 theme-icon-active" width="1em" height="1em">
            <use href="#circle-half"></use>
        </svg>
        <span class="visually-hidden" id="bd-theme-text">Toggle theme</span>
    </button>
    <ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="bd-theme-text">
        <li>
            <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light"
                    aria-pressed="false">
                <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em">
                    <use href="#sun-fill"></use>
                </svg>
                Light
                <svg class="bi ms-auto d-none" width="1em" height="1em">
                    <use href="#check2"></use>
                </svg>
            </button>
        </li>
        <li>
            <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark"
                    aria-pressed="false">
                <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em">
                    <use href="#moon-stars-fill"></use>
                </svg>
                Dark
                <svg class="bi ms-auto d-none" width="1em" height="1em">
                    <use href="#check2"></use>
                </svg>
            </button>
        </li>
        <li>
            <button type="button" class="dropdown-item d-flex align-items-center active" data-bs-theme-value="auto"
                    aria-pressed="true">
                <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em">
                    <use href="#circle-half"></use>
                </svg>
                Auto
                <svg class="bi ms-auto d-none" width="1em" height="1em">
                    <use href="#check2"></use>
                </svg>
            </button>
        </li>
    </ul>
</div>
<!--theme icon end-->

<!--top start-->
<svg xmlns="http://www.w3.org/2000/svg" class="d-none">
    <symbol id="calendar3" viewBox="0 0 16 16">
        <path d="M14 0H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM1 3.857C1 3.384 1.448 3 2 3h12c.552 0 1 .384 1 .857v10.286c0 .473-.448.857-1 .857H2c-.552 0-1-.384-1-.857V3.857z"/>
        <path d="M6.5 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm-9 3a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm3 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
    </symbol>
    <symbol id="cart" viewBox="0 0 16 16">
        <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
    </symbol>
    <symbol id="chevron-right" viewBox="0 0 16 16">
        <path fill-rule="evenodd"
              d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
    </symbol>
    <symbol id="door-closed" viewBox="0 0 16 16">
        <path d="M3 2a1 1 0 0 1 1-1h8a1 1 0 0 1 1 1v13h1.5a.5.5 0 0 1 0 1h-13a.5.5 0 0 1 0-1H3V2zm1 13h8V2H4v13z"/>
        <path d="M9 9a1 1 0 1 0 2 0 1 1 0 0 0-2 0z"/>
    </symbol>
    <symbol id="file-earmark" viewBox="0 0 16 16">
        <path d="M14 4.5V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h5.5L14 4.5zm-3 0A1.5 1.5 0 0 1 9.5 3V1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h-2z"/>
    </symbol>
    <symbol id="file-earmark-text" viewBox="0 0 16 16">
        <path d="M5.5 7a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zM5 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5z"/>
        <path d="M9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V4.5L9.5 0zm0 1v2A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5z"/>
    </symbol>
    <symbol id="gear-wide-connected" viewBox="0 0 16 16">
        <path d="M7.068.727c.243-.97 1.62-.97 1.864 0l.071.286a.96.96 0 0 0 1.622.434l.205-.211c.695-.719 1.888-.03 1.613.931l-.08.284a.96.96 0 0 0 1.187 1.187l.283-.081c.96-.275 1.65.918.931 1.613l-.211.205a.96.96 0 0 0 .434 1.622l.286.071c.97.243.97 1.62 0 1.864l-.286.071a.96.96 0 0 0-.434 1.622l.211.205c.719.695.03 1.888-.931 1.613l-.284-.08a.96.96 0 0 0-1.187 1.187l.081.283c.275.96-.918 1.65-1.613.931l-.205-.211a.96.96 0 0 0-1.622.434l-.071.286c-.243.97-1.62.97-1.864 0l-.071-.286a.96.96 0 0 0-1.622-.434l-.205.211c-.695.719-1.888.03-1.613-.931l.08-.284a.96.96 0 0 0-1.186-1.187l-.284.081c-.96.275-1.65-.918-.931-1.613l.211-.205a.96.96 0 0 0-.434-1.622l-.286-.071c-.97-.243-.97-1.62 0-1.864l.286-.071a.96.96 0 0 0 .434-1.622l-.211-.205c-.719-.695-.03-1.888.931-1.613l.284.08a.96.96 0 0 0 1.187-1.186l-.081-.284c-.275-.96.918-1.65 1.613-.931l.205.211a.96.96 0 0 0 1.622-.434l.071-.286zM12.973 8.5H8.25l-2.834 3.779A4.998 4.998 0 0 0 12.973 8.5zm0-1a4.998 4.998 0 0 0-7.557-3.779l2.834 3.78h4.723zM5.048 3.967c-.03.021-.058.043-.087.065l.087-.065zm-.431.355A4.984 4.984 0 0 0 3.002 8c0 1.455.622 2.765 1.615 3.678L7.375 8 4.617 4.322zm.344 7.646.087.065-.087-.065z"/>
    </symbol>
    <symbol id="graph-up" viewBox="0 0 16 16">
        <path fill-rule="evenodd"
              d="M0 0h1v15h15v1H0V0Zm14.817 3.113a.5.5 0 0 1 .07.704l-4.5 5.5a.5.5 0 0 1-.74.037L7.06 6.767l-3.656 5.027a.5.5 0 0 1-.808-.588l4-5.5a.5.5 0 0 1 .758-.06l2.609 2.61 4.15-5.073a.5.5 0 0 1 .704-.07Z"/>
    </symbol>
    <symbol id="house-fill" viewBox="0 0 16 16">
        <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
        <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
    </symbol>
    <symbol id="list" viewBox="0 0 16 16">
        <path fill-rule="evenodd"
              d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
    </symbol>
    <symbol id="people" viewBox="0 0 16 16">
        <path d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8Zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022ZM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4Zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0ZM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816ZM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275ZM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0Zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4Z"/>
    </symbol>
    <symbol id="plus-circle" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
    </symbol>
    <symbol id="puzzle" viewBox="0 0 16 16">
        <path d="M3.112 3.645A1.5 1.5 0 0 1 4.605 2H7a.5.5 0 0 1 .5.5v.382c0 .696-.497 1.182-.872 1.469a.459.459 0 0 0-.115.118.113.113 0 0 0-.012.025L6.5 4.5v.003l.003.01c.004.01.014.028.036.053a.86.86 0 0 0 .27.194C7.09 4.9 7.51 5 8 5c.492 0 .912-.1 1.19-.24a.86.86 0 0 0 .271-.194.213.213 0 0 0 .039-.063v-.009a.112.112 0 0 0-.012-.025.459.459 0 0 0-.115-.118c-.375-.287-.872-.773-.872-1.469V2.5A.5.5 0 0 1 9 2h2.395a1.5 1.5 0 0 1 1.493 1.645L12.645 6.5h.237c.195 0 .42-.147.675-.48.21-.274.528-.52.943-.52.568 0 .947.447 1.154.862C15.877 6.807 16 7.387 16 8s-.123 1.193-.346 1.638c-.207.415-.586.862-1.154.862-.415 0-.733-.246-.943-.52-.255-.333-.48-.48-.675-.48h-.237l.243 2.855A1.5 1.5 0 0 1 11.395 14H9a.5.5 0 0 1-.5-.5v-.382c0-.696.497-1.182.872-1.469a.459.459 0 0 0 .115-.118.113.113 0 0 0 .012-.025L9.5 11.5v-.003a.214.214 0 0 0-.039-.064.859.859 0 0 0-.27-.193C8.91 11.1 8.49 11 8 11c-.491 0-.912.1-1.19.24a.859.859 0 0 0-.271.194.214.214 0 0 0-.039.063v.003l.001.006a.113.113 0 0 0 .012.025c.016.027.05.068.115.118.375.287.872.773.872 1.469v.382a.5.5 0 0 1-.5.5H4.605a1.5 1.5 0 0 1-1.493-1.645L3.356 9.5h-.238c-.195 0-.42.147-.675.48-.21.274-.528.52-.943.52-.568 0-.947-.447-1.154-.862C.123 9.193 0 8.613 0 8s.123-1.193.346-1.638C.553 5.947.932 5.5 1.5 5.5c.415 0 .733.246.943.52.255.333.48.48.675.48h.238l-.244-2.855zM4.605 3a.5.5 0 0 0-.498.55l.001.007.29 3.4A.5.5 0 0 1 3.9 7.5h-.782c-.696 0-1.182-.497-1.469-.872a.459.459 0 0 0-.118-.115.112.112 0 0 0-.025-.012L1.5 6.5h-.003a.213.213 0 0 0-.064.039.86.86 0 0 0-.193.27C1.1 7.09 1 7.51 1 8c0 .491.1.912.24 1.19.07.14.14.225.194.271a.213.213 0 0 0 .063.039H1.5l.006-.001a.112.112 0 0 0 .025-.012.459.459 0 0 0 .118-.115c.287-.375.773-.872 1.469-.872H3.9a.5.5 0 0 1 .498.542l-.29 3.408a.5.5 0 0 0 .497.55h1.878c-.048-.166-.195-.352-.463-.557-.274-.21-.52-.528-.52-.943 0-.568.447-.947.862-1.154C6.807 10.123 7.387 10 8 10s1.193.123 1.638.346c.415.207.862.586.862 1.154 0 .415-.246.733-.52.943-.268.205-.415.39-.463.557h1.878a.5.5 0 0 0 .498-.55l-.001-.007-.29-3.4A.5.5 0 0 1 12.1 8.5h.782c.696 0 1.182.497 1.469.872.05.065.091.099.118.115.013.008.021.01.025.012a.02.02 0 0 0 .006.001h.003a.214.214 0 0 0 .064-.039.86.86 0 0 0 .193-.27c.14-.28.24-.7.24-1.191 0-.492-.1-.912-.24-1.19a.86.86 0 0 0-.194-.271.215.215 0 0 0-.063-.039H14.5l-.006.001a.113.113 0 0 0-.025.012.459.459 0 0 0-.118.115c-.287.375-.773.872-1.469.872H12.1a.5.5 0 0 1-.498-.543l.29-3.407a.5.5 0 0 0-.497-.55H9.517c.048.166.195.352.463.557.274.21.52.528.52.943 0 .568-.447.947-.862 1.154C9.193 5.877 8.613 6 8 6s-1.193-.123-1.638-.346C5.947 5.447 5.5 5.068 5.5 4.5c0-.415.246-.733.52-.943.268-.205.415-.39.463-.557H4.605z"/>
    </symbol>
    <symbol id="search" viewBox="0 0 16 16">
        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
    </symbol>
</svg>
<header class="navbar sticky-top bg-dark flex-md-nowrap p-0 shadow" data-bs-theme="dark">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6 text-white" href="#">宠物领养系统</a>

    <ul class="navbar-nav flex-row d-md-none">
        <li class="nav-item text-nowrap">
            <button class="nav-link px-3 text-white" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSearch" aria-controls="navbarSearch" aria-expanded="false"
                    aria-label="Toggle search">
                <svg class="bi">
                    <use xlink:href="#search"/>
                </svg>
            </button>
        </li>
        <li class="nav-item text-nowrap">
            <button class="nav-link px-3 text-white" type="button" data-bs-toggle="offcanvas"
                    data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false"
                    aria-label="Toggle navigation">
                <svg class="bi">
                    <use xlink:href="#list"/>
                </svg>
            </button>
        </li>
    </ul>

    <div id="navbarSearch" class="navbar-search w-100 collapse">
        <input class="form-control w-100 rounded-0 border-0" type="text" placeholder="Search" aria-label="Search">
    </div>
</header>
<!--top end-->

<!--contain start-->
<div class="container-fluid">
    <div class="row">

        <!--navibar start-->
        <div class="sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary">
            <div class="offcanvas-md offcanvas-end bg-body-tertiary" tabindex="-1" id="sidebarMenu"
                 aria-labelledby="sidebarMenuLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="sidebarMenuLabel">宠物领养系统</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" data-bs-target="#sidebarMenu"
                            aria-label="Close"></button>
                </div>
                <div class="offcanvas-body d-md-flex flex-column p-0 pt-lg-3 overflow-y-auto">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link d-flex align-items-center gap-2
                             active" aria-current="page" href="${basePath}/">
                                <svg class="bi">
                                    <use xlink:href="#puzzle"/>
                                </svg>
                                用户管理
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link d-flex align-items-center gap-2"
                               href="${basePath}/">
                                <svg class="bi">
                                    <use xlink:href="#puzzle"/>
                                </svg>
                                管理员管理
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link d-flex align-items-center gap-2"
                               href="${basePath}/">
                                <svg class="bi">
                                    <use xlink:href="#puzzle"/>
                                </svg>
                                宠物管理
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link d-flex align-items-center gap-2"
                               href="${basePath}/">
                                <svg class="bi">
                                    <use xlink:href="#puzzle"/>
                                </svg>
                                领养管理
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link d-flex align-items-center gap-2"
                               href="${basePath}/">
                                <svg class="bi">
                                    <use xlink:href="#puzzle"/>
                                </svg>
                                评论管理
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link d-flex align-items-center gap-2"
                               href="${basePath}/">
                                <svg class="bi">
                                    <use xlink:href="#puzzle"/>
                                </svg>
                                团队活动管理
                            </a>
                        </li>
                    </ul>

                    <hr class="my-3">

                    <ul class="nav flex-column mb-auto">
                        <li class="nav-item">
                            <form action="${basePath}/admin/logout.action" method="POST"
                                  class="nav-link d-flex align-items-center gap-2">
                                <svg class="bi">
                                    <use xlink:href="#door-closed"/>
                                </svg>
                                <input type="submit" value="Sign out"
                                       onclick="return confirm('确定要登出吗？')"/>
                            </form>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--navibar end-->

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <%--toolbar start--%>
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">用户活动管理</h1>
                <div class="col-auto">
                    <!--新增实体对象按钮-->
                    <%--data-bs-target => 模态框ID--%>
                    <button class="btn btn-primary" type="button" data-bs-toggle="modal"
                            data-bs-target="#user-Create-Edit" id="form-insert">
                        新增用户
                    </button>
                    <!--搜索框-->
                    <label for="search-condition">搜索条件：</label>
                    <select id="search-condition">
                        <option value="id">ID</option>
                        <option value="username">活动事件</option>
                    </select>

                    <label for="search-content">搜索内容：</label>
                    <input type="text" id="search-content">

                    <button href="#" id="search-button">搜索</button>
                </div>
            </div>
            <%--toolbar end--%>

            <%--table start--%>
            <div class="table-responsive small">
                <table class="table table-striped table-sm" id="myContent">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">活动时间</th>
                        <th scope="col">活动地点</th>
                        <th scope="col">活动人物</th>
                        <th scope="col">活动描述</th>
                        <th scope="col">标题</th>
                        <th scope="col">&nbsp;</th>
                        <th scope="col">&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!--数据库获取JSON到表格-->
                    </tbody>
                </table>
                <!--页数-->
                <nav aria-label="...">
                    <ul class="pagination" id="pagination">
                        <li class="page-item disabled" id="pageItemFirst">
                            <a class="page-link" href="#" onclick="firstpage()">首页</a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item active" aria-current="page">
                            <a class="page-link" href="#">2</a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item" id="pageItemLast">
                            <a class="page-link" href="#" onclick="lastPage()">尾页</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <%--table end--%>

            <!--增加/修改用户信息 modal start-->
            <div class="modal fade" id="user-Create-Edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="myModalLabel">新建/修改活动信息</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" id="uForm">
                                <div class="form-group">
                                    <label for="actionTime" class="col-sm-2 control-label">
                                        活动时间
                                    </label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="actionTime" placeholder="活动时间"
                                               name="actionTime">
                                        <input type="hidden" id="id" name="id"/>
                                    </div>
                                    <label for="address" class="col-sm-2 control-label">
                                        活动地点
                                    </label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="address" placeholder="活动地点"
                                               name="address">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="peoples" class="col-sm-2 control-label">
                                        活动人物
                                    </label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="peoples" placeholder="活动人物"
                                               name="peoples">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="event" class="col-sm-2 control-label">
                                        活动描述
                                    </label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="event" placeholder="活动描述"
                                               name="event">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="title" class="col-sm-2 control-label">
                                        标题
                                    </label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="title" placeholder="标题"
                                               name="title">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-bs-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" id="btn-insert" myattribute="insert"
                                    onclick="insert()">创建活动
                            </button>
                            <button type="button" class="btn btn-secondary" id="btn-update" myattribute="update"
                                    onclick="update()">修改活动
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <!--增加/修改用户信息 modal end-->

            <!-- Modal start-->
            <div class="modal fade" id="tipModal" tabindex="-1" aria-labelledby="tipTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="tipTitle">宠物领养系统</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body" id="tipContent">
                            ...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-danger" id="btnConfirm">删除</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Modal nd-->

        </main>
    </div>
</div>
<!--contain end-->

<%--检索--%>
<script>
    var myModalAlternative;
    var pageSize = 10;

    //$(document).ready(function () { ... })等价$(function () { ... }
    $(document).ready(function () {
        myModalAlternative = new bootstrap.Modal('#tipModal', {"backdrop": false, "keyboard": false});
        getList(1);
        //清除表单内容
        clearForm();
    });

    function getList(pageNum) {
        console.log("pageNum: " + pageNum);
        console.log("pageSize: " + pageSize);
        $.ajax({
            url: 'http://localhost:4444/blog/allPage.action',
            type: 'GET',
            dataType: 'json',
            data: {
                "pageSize": pageSize,
                "pageNum": pageNum
            },
            success: function (data) {
                //当参数为true时，从mock读取数据，这时需要将字符串转换为JSON对象
                if (MOCK == 'true') data = JSON.parse(data);
                console.log(data);
                if ((data.code == 4007) && (data.status == 200)) {
                    var pageInfo = data.data;
                    var list = pageInfo.list;
                    $("#myContent tbody").html(""); // 清空之前的表格内容
                    for (var i = 0; i < list.length; i++) {
                        var blog = list[i];
                        $("#myContent tbody").append
                        (
                            //tr的ID用来实现删除操作后实时删除表格内对应的行
                            "<tr id='tr" + blog.id + "'><td>" + blog.id + "</td><td>"
                            + blog.actionTime + "</td><td>"
                            + blog.address + "</td><td>"
                            + blog.peoples + "</td><td>"
                            + blog.event + "</td><td>"
                            + blog.title + "</td><td>"+
                            "<a href='${basePath}/admin/blog/blogEdit.jsp?id=" + blog.id + "' class='btn btn-warning' id='form-update'>编辑</a> </td><td>" +
                            "<a href='javascript:void(0);' class='btn btn-danger' onclick='confirmDelete(" + blog.id + ")'>删除</a></td></tr>"
                        );
                    }

                    $("#pagination").html(""); // 清空之前的分页信息
                    var liHtml = '<li class="page-item disabled" id="pageItemFirst">' +
                        '<a class="page-link" href="#" onclick="getList(1)">首页</a>' +
                        '</li>';
                    liHtml = liHtml + '<li class="page-item" id="pageItemPrev">' +
                        '<a class="page-link" href="#" onclick="getList(' + pageInfo.prePage + ')">上一页</a>' +
                        '</li>';
                    var vcount = 0;
                    for (var i = pageInfo.pageNum - 1; i < pageInfo.pageNum + 2; i++) {
                        if (i >= 0 && i < pageInfo.navigatepageNums.length) {
                            liHtml = liHtml + '<li class="page-item">' +
                                '<a class="page-link" href="#" onclick="getList(' + pageInfo.navigatepageNums[i] + ')">' +
                                pageInfo.navigatepageNums[i] + '</a></li>';
                        }
                    }
                    liHtml = liHtml + '<li class="page-item" id="pageItemNext">' +
                        '<a class="page-link" href="#" onclick="getList(' + pageInfo.nextPage + ')">下一页</a></li>' +
                        '<li class="page-item" id="pageItemLast">' +
                        '<a class="page-link" href="#" onclick="getList(' + pageInfo.pages + ')">尾页</a></li>';
                    $("#pagination").html(liHtml);
                    $("#pageItemFirst").removeClass("disabled");
                    if (pageInfo.isLastPage) {    //最后一页
                        $("#pageItemLast").addClass("disabled");        //最后一页禁用
                        $("#pageItemNext").addClass("disabled");        //下一页禁用
                        $("#pageItemFirst").removeClass("disabled");    //第一页的禁用样式取消
                        $("#pageItemPrev").removeClass("disabled");     //上一页的禁用样式取消
                    }
                    if (pageInfo.isFirstPage) {   //第一页
                        $("#pageItemFirst").addClass("disabled");
                        $("#pageItemPrev").addClass("disabled");
                        $("#pageItemNext").removeClass("disabled");
                        $("#pageItemLast").removeClass("disabled");
                    }
                } else {
                    alert("读取失败！");
                }
            }
        });
    }

    /*监听搜索按钮*/
    $("#search-button").click(function () {
        var condition = $("#search-condition").val();
        var content = $("#search-content").val();
        console.log("condition: " + condition);
        console.log("content: " + content);
        // 如果内容都为空，显示全部用户信息
        if (content === "") {
            getList(1);
        } else if (condition === "id" && content !== "") {
            // 如果搜索条件有效，根据条件和内容搜索并显示用户信息
            $.ajax({
                url: "http://localhost:4444/admin/findById.json.action", // 假设是根据用户名搜索，你可以根据实际需要修改这个URL
                data: {id: content},
                method: "GET",
                success: function (data) {
                    console.log(data);
                    if ((data.code == 4001) && (data.status == 200)) {
                        $("#myContent tbody").empty(); // 清空之前的内容
                        for (var i = 0; i < list.length; i++) {
                            var blog = list[i];
                            $("#myContent tbody").append
                            (
                                //tr的ID用来实现删除操作后实时删除表格内对应的行
                                "<tr id='tr" + blog.id + "'><td>" + blog.id + "</td><td>"
                                + blog.actionTime + "</td><td>"
                                + blog.address + "</td><td>"
                                + blog.peoples + "</td><td>"
                                + blog.event + "</td><td>"
                                + blog.title + "</td><td>"+
                                "<a href='${basePath}/admin/blog/blogEdit.jsp?id=" + blog.id + "' class='btn btn-warning' id='form-update'>编辑</a> </td><td>" +
                                "<a href='javascript:void(0);' class='btn btn-danger' onclick='confirmDelete(" + blog.id + ")'>删除</a></td></tr>"
                            );
                        }
                    }
                }
            });
        } else if (condition === "actionTime" && content !== "") {
            // 如果搜索条件有效，根据条件和内容搜索并显示用户信息
            $.ajax({
                url: "http://localhost:4444/blog/findByName.json.action",
                data: {name: content},
                method: "GET",
                success: function (data) {
                    console.log(data);
                    if ((data.code == 4002) && (data.status == 200)) {
                        $("#myContent tbody").empty(); // 清空之前的内容
                        for (var i = 0; i < data.data.length; i++) {
                            var blog = data.data[i];
                            $("#myContent tbody").append
                            (
                                "<tr id='tr" + blog.id + "'><td>" + blog.id + "</td><td>"
                                + blog.actionTime + "</td><td>"
                                + blog.address + "</td><td>"
                                + blog.peoples + "</td><td>"
                                + blog.event + "</td><td>"
                                + blog.title + "</td><td>"+
                                "<a href='${basePath}/admin/blog/blogEdit.jsp?id=" + blog.id + "' class='btn btn-warning' id='form-update'>编辑</a> </td><td>" +
                                "<a href='javascript:void(0);' class='btn btn-danger' onclick='confirmDelete(" + blog.id + ")'>删除</a></td></tr>"
                            );
                        }
                    }
                }
            });
        }
    });
</script>
<%--删除操作--%>
<script>
    function confirmDelete(id) {
        $("#tipContent").html("确认删除对应ID数据：" + id);      //设置对话框内容
        $("#btnConfirm").text("删除");                            //设置对话框按钮的标题
        $("#btnConfirm").off("click");                              //解绑确定按钮单击的所有事件
        $("#btnConfirm").on("click", function () {
            deleteUser(id)
        });  //为对话框的确认按钮添加事件

        myModalAlternative.toggle();      //显示对话框。
    }

    function deleteUser(id) {
        myModalAlternative.toggle();
        $.ajax({
            url: "http://localhost:4444/blog/delete.json.action",
            data: {id: id},
            method: "POST",
            success: function (data) {
                console.log(data, data.code, data.status);
                if (data.code == 4005) {
                    if (data.status == 200) {
                        alert(data.msg);
                        //删除这一行
                        console.log($("tr" + id));//返回长度为0，删除成功
                        $("#tr" + id).remove();

                    } else {
                        alert(data.msg);
                    }
                } else {
                    alert("系统错误！错误代码：" + data.code);
                }
            }
        });
    }
</script>
<%--清空表单--%>
<script>
    function clearForm() {
        // 获取表单中的所有输入元素
        var inputs = document.getElementsByTagName("input");

        // 遍历所有输入元素
        for (var i = 0; i < inputs.length; i++) {
            // 判断输入元素是否为文本框类型
            if (inputs[i].type == "text") {
                // 清空文本框内容
                inputs[i].value = "";
            }
            // 判断输入元素是否为文件选择器类型
            if (inputs[i].type == "file") {
                // 清空文件选择器内容
                inputs[i].value = "";
            }
        }
    }
</script>
<%--增加/修改操作--%>
<script>
    function check() {

        var isCheck = true;
        var id = $("#id").val();
        var actionTime = $("#actionTime").val();
        var address = $("#address").val();
        var peoples = $("#peoples").val();
        var event = $("#event").val();
        var title = $("#title").val();
        if (actionTime.trim().length == 0) {
            isCheck = false;
            alert("请输入活动时间！");
            $("#actionTime").focus();
        }

        if (address.trim().length == 0) {
            isCheck = false;
            alert("请输入活动地点！");
            $("#address").focus();
        }


        if (peoples.trim().length == 0) {
            isCheck = false;
            alert("请输入活动人物！");
            $("#peoples").focus();
        }

        if (event.trim().length == 0) {
            isCheck = false;
            alert("请输入活动描述！");
            $("#event").focus();
        }

        if (title.trim().length == 0) {
            isCheck = false;
            alert("请输入标题！");
            $("#title").focus();
        }

        return isCheck;
    }

    function insert() {
        if (check()) {
            var actionTime = $("#actionTime").val();
            var address = $("#address").val();
            var peoples = $("#peoples").val();
            var event = $("#event").val();
            var title = $("#title").val();
            //JQuery函数，用于获取表单数据并将其作为URL编码字符串返回
            console.log($("#uForm").serialize());
            // 调用增加ajax操作
            console.log("insert");
            $.ajax({
                url: 'http://localhost:4444/blog/insert.json.action',
                type: 'POST',
                dataType: 'JSON',
                data: {
                    'actionTime': actionTime,
                    'address': address,
                    'peoples': peoples,
                    'event': event,
                    'title': title
                },
                success: function (data) {
                    console.log(data.code, data.status, data.msg);
                    if (data.code == 4003) {    //比较业务代码是否正确
                        alert(data.msg);    //在页面提示信息
                        if (data.status == 200) {
                            clearForm();    //成功后清除表单
                            window.location.href = "${basePath}/admin/blog/blog.jsp";
                        }
                    } else {
                        alert("系统出错！code: " + data.code);
                    }
                }
            });
        } else {
            alert("请检查输入！");
        }
        return false;
    }

    function update() {
        if (check()) {
            var id = $("#id").val();
            var actionTime = $("#actionTime").val();
            var address = $("#address").val();
            var peoples = $("#peoples").val();
            var event = $("#event").val();
            var title = $("#title").val();
            //JQuery函数，用于获取表单数据并将其作为URL编码字符串返回
            console.log($("#uForm").serialize());
            // 调用修改ajax操作
            console.log("update");
            var dataObject = {
                'actionTime': actionTime,
                'address': address,
                'peoples': peoples,
                'event': event,
                'title': title
            }
            $.ajax({
                url: 'http://localhost:4444/blog/update.json.action',
                type: 'POST',
                dataType: 'JSON',
                contentType: 'application/json',
                data: JSON.stringify(dataObject),
                success: function (data) {
                    console.log(data.code, data.status, data.msg);
                    if (data.code == 4004) {    //比较业务代码是否正确
                        alert(data.msg);    //在页面提示信息
                        if (data.status == 200) {
                            //clearForm();    //成功后清除表单
                            window.location.href = "${basePath}/admin/blog/blog.jsp";
                        }
                    } else {
                        alert("系统出错！code: " + data.code);
                    }
                }
            });
        } else {
            alert("请检查输入！");
        }
        return false;
    }



    /*    $(function () {
            $('#form-update').addEventListener("click", function (e) {

                /!*
                            e.preventDefault();
                *!/
                //获取参数id，由于参数格式是id=xx，所有使用split("=")来分割参数和值
                // var q = window.location.search.substring(1);
                console.log(this.href);
                console.log(q);
                var qarrs = q.split("=");
                var id = qarrs[1];
                console.log(id);
                //根据id从服务器读取数据
                $.ajax({
                    url: 'http://localhost:4444/user/findById.json.action',
                    type: 'GET',
                    dataType: 'JSON',
                    data: {"id": id},
                    success: function (data) {
                        if (data.code == 8001) {
                            if (data.status == 200) {
                                //读取数据成功，将数据置入表单中。
                                var user = data.data;
                                $("#id").val(user.id);
                                $("#userName").val(user.userName);
                                $("#userPwd").val(user.userPwd);
                                $("#sex").val(user.sex);
                                $("#age").val(user.age);
                                $("#telephone").val(user.telephone);
                                $("#email").val(user.email);
                                $("#address").val(user.address);
                                $("#pic").val(user.pic);
                                $("#state").val(user.state);
                                /!*                            var userJSON = JSON.stringify(user);
                                                            $("#form-update").attr("action", userJSON); // 设置form的action属性为userJSON
                                                            $("#form-update").submit(); // 提交表单*!/
                            } else {
                                alert("查询不到该数据，请重试！");
                            }
                        } else {
                            alert("系统错误，请重试！");
                        }
                    }
                });
            });
        });*/
</script>
<%--文件上传--%>
<script>
    function ajaxSubmit() {

        var fileForm = new FormData($("#uploadForm")[0]);

        $.ajax({
            url: 'http://localhost:4444/blog/upload.action',
            data: fileForm,
            type: 'post',
            dataType: 'json',
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                var code = data.code;
                var status = data.status;
                alert(data.msg);
                if (status == 200 && code == 4006) {
                    //成功！
                    console.log(data.data);
                } else {
                    console.log(data.msg);
                }

            }
        });

        return false;
    }

    /*相关form使用*/
    /*    <form id="uploadForm" class="form-control" method="post" enctype="multipart/form-data" onsubmit="return ajaxSubmit()" >
            <input type="file" name="file" id="uploadfile" />
            <input type="submit" />*/
</script>
<script src="${basePath}/assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@4.3.2/dist/chart.umd.js"
        integrity="sha384-eI7PSr3L1XLISH8JdDII5YN/njoSsxfbrkCTnJrzXt+ENP5MOVBxD+l6sEG4zoLp"
        crossorigin="anonymous"></script>
<script src="${basePath}/assets/js/dashboard.js"></script>
</body>
</html>
