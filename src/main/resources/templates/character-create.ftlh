<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Wurm Online Creatures</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
  <header>
    <div>
      <h1>Wurm Online Creatures</h1>
      <nav>
        <div>
          <a href="index.html">Home</a>
        </div>
        <div>
          <a href="about.html">About</a>
        </div>
        <div>
          <a href="new-character-form.html">Add a Creature</a>
        </div>
      </nav>
    </div>
  </header>

  <main class="new-character-form">
    <h2>Add New Creature</h2>
    <form>
      <fieldset>
        <h3>Basic Information</h3>
        <label>
          Title
          <input type="text" name="title" required>
        </label>
        <label>
          In-game Description
          <textarea name="ingame-description" rows="4" required></textarea>
        </label>

        <label>
          About Text
          <textarea name="about-text" rows="6" required></textarea>
        </label>

        <label>
          Update History Text
          <textarea name="history-text" rows="6"></textarea>
        </label>
      </fieldset>

      <fieldset class="tags">
        <h3>Tags</h3>
        <label>
          Valreian
          <input type="checkbox" name="tags[]" value="Valreian">
        </label>
        <label>
          Wurmian
          <input type="checkbox" name="tags[]" value="Wurmian">
        </label>
        <label>
          Avatar
          <input type="checkbox" name="tags[]" value="Avatar">
        </label>
        <label>
          Spider
          <input type="checkbox" name="tags[]" value="Spider">
        </label>
        <label>
          Passive
          <input type="checkbox" name="tags[]" value="Passive">
        </label>
        <label>
          Aggressive
          <input type="checkbox" name="tags[]" value="Aggressive">
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
          <input type="file" name="main-image" accept="image/*">
        </label>
      </fieldset>
    </form>
    <div class="form-actions">
      <button class="submit" type="submit">Create Creature</button>
    </div>
    </article>
  </main>

  <footer>
    <div>
      <p>Site created by Daniel Valcour (<a href="https://github.com/jmandevel">jmandevel</a>) (<a
          href="https://github.com/jmandevel/creature-site">Source Code</a>)</p>
    </div>
  </footer>
</body>

</html>