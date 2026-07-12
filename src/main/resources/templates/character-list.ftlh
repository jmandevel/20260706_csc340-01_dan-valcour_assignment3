<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wurm Online Creatures</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
</head>

<body>
    <header>
        <div>
            <h1>Wurm Online Creatures</h1>
            <nav>
                <div>
                    <a href="/characters">Home</a>
                </div>
                <div>
                    <a href="/characters/about">About</a>
                </div>
                <div>
                    <a href="/characters/new">Add a Creature</a>
                </div>
            </nav>
        </div>
    </header>

    <search>
        <div class="search-bar">
            <input type="" text" class="search" placeholder="Search creatures...">
            <button>Search</button>
        </div>
    </search>

    <main class="card-container">
        <#list charactersList as character>
            <div class="card">
                <img src="/${(character.thumbnailPath)!}" alt="${character.name}">
                <h2>${character.name}</h2>
                <p class="origin"><strong>Origin:</strong> ${character.origin}</p>
                <p class="description">${character.ingameDescription}</p>
                <a href="/characters/${character.id}"><button>More Info</button></a>
            </div>
        </#list>
    </main>

    <footer>
        <div>
            <p>Site created by Daniel Valcour (<a href="https://github.com/jmandevel">jmandevel</a>) (<a
                    href="https://github.com/jmandevel/20260706_csc340-01_dan-valcour_assignment3">Source Code</a>)</p>
        </div>
    </footer>
</body>

</html>