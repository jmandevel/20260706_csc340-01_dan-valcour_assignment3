<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${pageTitle}</title>
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

  <main class="about">
    <article class="creature-description">
      <h2>${character.name}</h2>
      <img src="/${(character.mainImagePath)!}" alt="${character.name}">
      <blockquote class="ingame-quote"><em>${character.ingameDescription}</em> - ingame description
      </blockquote>
      <h3>General Info</h3>
      <p>
        ${character.description}
      </p>
      <a href="/characters/updateForm/${character.id}"><button>Update</button></a>
      <a href="/characters/delete/${character.id}"><button>Delete</button></a>
    </article>
  </main>

  <footer>
    <div>
      <p>Site created by Daniel Valcour (<a href="https://github.com/jmandevel">jmandevel</a>) (<a
          href=https://github.com/jmandevel/20260706_csc340-01_dan-valcour_assignment3>Source Code</a>)</p>
    </div>
  </footer>
</body>

</html>