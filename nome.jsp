<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Analizza <%= request.getParameter("nome") %></title>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">

    <!-- Tailwind.css per la grafica -->
    <script src="https://cdn.tailwindcss.com"></script>
    <!-- Grafica custom -->
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body class="bg-white dark:bg-slate-900 text-black dark:text-white">

<img src="./assets/img/light_background.png" class="w-100 -z-20 absolute dark:hidden">
<img src="./assets/img/dark_background.png" class="w-100 -z-20 hidden absolute dark:block">

<div v-scope class="z-40 w-100 h-screen p-8 flex justify-center items-center flex-col">
    <div class="flex justify-center items-center flex-col mb-4">
        <h1 class="font-extrabold text-4xl tracking-tight text-center">
            <span class="mr-4">&#128300;</span>
            Analisi di&nbsp;
            <span class="before:block before:absolute before:-inset-1 before:-skew-y-3 before:bg-pink-500 relative inline-block">
                  <span class="relative text-white"><%= request.getParameter("nome").substring(0, 1).toUpperCase() + request.getParameter("nome").substring(1) %></span>
            </span>
        </h1>
    </div>
    <div class="flex justify-center items-center flex-wrap">
        <div class="ring-2 ring-sky-500 min-w-[15rem] py-8 m-8 flex justify-center items-center flex-col g-white shadow-sm rounded-lg text-slate-400 dark:bg-slate-800 dark:text-slate-300 dark:highlight-white/5">
            <h3 class="font-extrabold text-xl mb-4">
                Nazione
            </h3>
            <span class="text-center">
                ${nazione}
            </span>
        </div>
        <div class="ring-2 ring-sky-500 min-w-[15rem] py-8 m-8 flex justify-center items-center flex-col g-white shadow-sm rounded-lg text-slate-400 dark:bg-slate-800 dark:text-slate-300 dark:highlight-white/5">
            <h3 class="font-extrabold text-xl mb-4">
                Età
            </h3>
            <span class="text-center">
                ${eta}
            </span>
        </div>
        <div class="ring-2 ring-sky-500 min-w-[15rem] py-8 m-8 flex justify-center items-center flex-col g-white shadow-sm rounded-lg text-slate-400 dark:bg-slate-800 dark:text-slate-300 dark:highlight-white/5">
            <h3 class="font-extrabold text-xl mb-4">
                Genere
            </h3>
            <span class="text-center">
                ${genere}
            </span>
        </div>
    </div>

    <a href="/web-service" class="absolute bottom-6 right-6 md:top-2 md:bottom-auto md:right-auto md:left-10 mt-8 rounded-2xl py-3 px-3 g-white ring-1 ring-slate-900/10 hover:ring-slate-300 focus:outline-none focus:ring-2 focus:ring-sky-500 shadow-sm rounded-lg text-slate-400 dark:bg-slate-800 dark:ring-0 dark:text-slate-300 dark:highlight-white/5 dark:hover:bg-slate-700">
        <div class="flex justify-center items-center">
            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                <path stroke-linecap="round" stroke-linejoin="round" d="M15 19l-7-7 7-7" />
            </svg>
            <span>Torna alla home</span>
        </div>
    </a>
</div>

</div>
</body>
</html>

