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

  <main class="new-character-form">
    <h2>Update an Existing Creature</h2>
    <form 
      action="/characters/change/${characterId}"
      method="post"
      enctype="multipart/form-data">
      <fieldset>
        <h3>Basic Information</h3>
        <div>
          <label for="name">
            Name
          </label>
          <input type="text" name="name" required value="${(dto.name)!}">
        </div>
        <div>
          <label for="description">
            In-game Description
          </label>
          <textarea id="description" name="description" rows="4" required>
            ${(dto.description)!}
           </textarea>
        </div>
        <div>
          <label for="ingameDescription">
            Ingame Description
          </label>
          <textarea id="ingameDescription" name="ingameDescription" rows="4" required>
            ${(dto.ingameDescription)!}  
          </textarea>
        </div>
        <div>
          <label for="origin">
            Origin
          </label>
          <input type="text" id="origin" name="origin" value="${(dto.origin)!}">
        </div>
      </fieldset>

      <fieldset class="tags">
        <h3>Tags</h3>
        <label>
          Avatar
          <input type="checkbox" name="avatar" <#if dto?? && dto.avatar>checked</#if>>
        </label>
        <label>
          Spider
          <input type="checkbox" name="spider" <#if dto?? && dto.spider>checked</#if>>
        </label>
        <label>
          Passive
          <input type="checkbox" name="passive" <#if dto?? && dto.passive>checked</#if>>
        </label>
        <label>
          Aggressive
          <input type="checkbox" name="aggressive" <#if dto?? && dto.aggressive>checked</#if>>
        </label>
      </fieldset>

      <fieldset>
        <label>
          <h3>Images</h3>
          Thumbnail Image (index page)
          <input type="file" name="thumbnail" accept="image/*">
        </label>

        <label>
          Main Image (detail page)
          <input type="file" name="mainImage" accept="image/*">
        </label>
      </fieldset>
      <div class="form-actions">
        <button class="submit" type="submit">Update Creature</button>
      </div>
    </form>

    </article>
  </main>

  <footer>
    <div>
      <p>Site created by Daniel Valcour (<a href="https://github.com/jmandevel">jmandevel</a>) (<a
          href="https://github.com/jmandevel/20260706_csc340-01_dan-valcour_assignment3">Source Code</a>)</p>
    </div>
  </footer>
</body>

</html>