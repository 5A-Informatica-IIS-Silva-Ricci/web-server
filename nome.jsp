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

        <!-- Logica frontend -->
        <script type="module">
                import {createApp} from 'https://unpkg.com/petite-vue?module'
                import script from "./assets/js/script.js";

                createApp({
                        nome: 'Giulio'
                }).mount()
        </script>
</head>
<body class="bg-white dark:bg-slate-900 text-black dark:text-white">

<img src="./assets/img/light_background.png" class="w-100 -z-20 absolute dark:hidden">
<img src="./assets/img/dark_background.png" class="w-100 -z-20 hidden absolute dark:block">

<div v-scope class="z-40 w-100 h-screen p-8 flex justify-center items-center flex-col">
        <div class="flex justify-center items-center flex-col">
                <h1 class="font-extrabold text-4xl tracking-tight text-center">
                        <span class="mr-4">&#128300;</span>
                        Analisi di
                        <span class="before:block before:absolute before:-inset-1 before:-skew-y-3 before:bg-pink-500 relative inline-block">
                  <span class="relative text-white">{{ nome }}</span>
            </span>
                </h1>
        </div>
        <div class="flex justify-center items-center">
                <div class="h-20 w-40 m-8 flex justify-center items-center g-white ring-1 ring-slate-900/10 hover:ring-slate-300 focus:outline-none focus:ring-2 focus:ring-sky-500 shadow-sm rounded-lg text-slate-400 dark:bg-slate-800 dark:ring-0 dark:text-slate-300 dark:highlight-white/5 dark:hover:bg-slate-700">
                        <h3 class="font-extrabold text-xl">
                                Nazione
                        </h3>
                        <span>
                <%= request.getParameter("countryBean").getCountryId() %>
                                </br>
                                Probabilita' <%= request.getParameter("countryBean").getProbabilityString() %>
            </span>
                </div>
                <div class="h-20 w-40 m-8 flex justify-center items-center g-white ring-1 ring-slate-900/10 hover:ring-slate-300 focus:outline-none focus:ring-2 focus:ring-sky-500 shadow-sm rounded-lg text-slate-400 dark:bg-slate-800 dark:ring-0 dark:text-slate-300 dark:highlight-white/5 dark:hover:bg-slate-700">
                        <h3 class="font-extrabold text-xl">
                                Eta
                        </h3>
                        <span>
                <%= request.getParameter("ageBean").getAge() %>
            </span>
                </div>
                <div class="h-20 w-40 m-8 flex justify-center items-center g-white ring-1 ring-slate-900/10 hover:ring-slate-300 focus:outline-none focus:ring-2 focus:ring-sky-500 shadow-sm rounded-lg text-slate-400 dark:bg-slate-800 dark:ring-0 dark:text-slate-300 dark:highlight-white/5 dark:hover:bg-slate-700">
                        <h3 class="font-extrabold text-xl">
                                Genere
                        </h3>
                        <span>
                <%= request.getParameter("genderBean").getGenderString() %>
            </span>
                </div>
        </div>
</div>

</div>
</body>
</html>
