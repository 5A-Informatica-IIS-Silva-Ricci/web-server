<%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!doctype html>
        <html lang="it">
        <head>
        <meta charset="UTF-8">
        <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <title>Analizza <%= request.getParameter("nome"); %></title>

        <!-- Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">

        <!-- Tailwind.css per la grafica -->
        <script src="https://cdn.tailwindcss.com"></script>
        <!-- Grafica custom -->
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- Logica frontend -->
        <script type="module">
        import {createApp} from 'https://unpkg.com/petite-vue?module'
        import script from "./assets/js/script.js";

        createApp({
        }).mount()
        </script>
        </head>
        <body class="bg-white dark:bg-slate-900 text-black dark:text-white">

        <img src="./assets/img/light_background.png" class="w-100 -z-20 absolute dark:hidden">
        <img src="./assets/img/dark_background.png" class="w-100 -z-20 hidden absolute dark:block">

        <div v-scope class="z-40 w-100 h-screen p-8 flex justify-center items-center flex-col">

        </div>
        </body>
        </html>
