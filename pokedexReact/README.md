# 🎮 Pokédex — React + Vite

An interactive Pokédex built with React and Vite as part of **Activity 03** for the Web Application Development and Integration course.

The application allows users to explore Pokémon, search by name or ID, filter by type, and inspect their base stats through a custom-designed interface. It also features a trainer section where users can explore trainers, their badges, and their associated Pokémon.

## ✨ Features

### Pokémon Explorer
- Browse the Pokémon available in the provided dataset.
- View Pokémon names, IDs, and types.
- Explore base stats, including HP, Attack, Defense, Special Attack, Special Defense, and Speed.
- Search Pokémon by name or ID.
- Filter Pokémon by type.
- Select a Pokémon to view its detailed information.
- Handle searches that return no results.

### Trainer Explorer
- Browse the available Pokémon trainers.
- View trainer information and badge counts.
- Explore the Pokémon associated with each trainer.
- Display trainer sprites using images hosted by Pokémon Showdown.

### User Interface
- Custom visual identity inspired by the Pokémon universe.
- Interactive components and visual feedback.
- Pokémon type indicators and stat visualizations.
- Reusable React components for a more organized codebase.

## 🛠️ Technologies

- **React** — Component-based user interface.
- **Vite** — Development server and build tooling.
- **JavaScript / TypeScript** — Application logic and data handling, depending on the project's configured source files.
- **CSS** — Layout, styling, and visual effects.
- **JSON** — Local Pokémon and trainer dataset.
- **Pokémon Showdown Sprites** — Trainer images hosted at [play.pokemonshowdown.com/sprites/trainers](https://play.pokemonshowdown.com/sprites/trainers/).

## 📂 Project Structure

The project follows a component-based architecture. Its main directories are organized around the interface, reusable components, styling, and data.

```text
src/
├── assets/
├── components/
├── data/
│   └── pokedex-data.json
├── css/
├── App.jsx
├── main.jsx
└── index.css

public/
package.json
README.md
```

*Note: The structure above is illustrative. Adapt it to match the actual files and directories in the repository.*

## 🚀 Getting Started

### Prerequisites

- Node.js
- npm
- Git (optional, for cloning the repository)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/T0RR35/Atividades_DIAW
   ```

2. Navigate to the project directory:

   ```bash
   cd pokedexReact
   ```

3. Install the dependencies:

   ```bash
   npm install
   ```

4. Start the development server:

   ```bash
   npm run dev
   ```

5. Open the local URL displayed in the terminal, usually:

   ```text
   http://localhost:5173
   ```

## 📊 Data Source

The application uses the Pokémon dataset provided for the assignment:

[pokedex-data.json — Course Repository](https://github.com/joaopauloaramuni/desenvolvimento-e-integracao-de-aplicacoes-web/blob/main/ATIVIDADES/ATIVIDADE%2003%20-%20JSON/data/pokedex-data.json)

The dataset contains Pokémon information, base stats, types, trainers, badge counts, and relationships between trainers and Pokémon.

Trainer sprites are retrieved from the Pokémon Showdown sprite directory:

[Pokémon Showdown — Trainer Sprites](https://play.pokemonshowdown.com/sprites/trainers/)

## 🗺️ Future Improvements

The core required features have been implemented. The following enhancements are planned for future development:

- [ ] **Pokémon Comparison** — Select two Pokémon and compare their base stats.
- [ ] **Sorting** — Sort Pokémon by name, ID, or individual stats.
- [ ] **Random Pokémon** — Add a button to discover a randomly selected Pokémon.
- [ ] **Responsive Design** — Improve the layout and interactions for desktop, tablet, and mobile screens.

These improvements will expand the application's functionality and usability beyond the initial assignment requirements.

## 🎓 Learning Objectives

This project provides practical experience with:

- React functional components and props.
- State management with `useState`.
- Event handling and user interactions.
- Dynamic list rendering with `map()`.
- Searching and filtering datasets.
- Component reusability and frontend organization.
- CSS styling and interface design.
- Displaying structured JSON data in a web application.

## 👥 Contributors

Developed collaboratively through pair programming as part of an academic assignment.

- **Rafael Torres** — [@T0RR35](https://github.com/T0RR35)
- **Daniel Gomes** — [@TaroNukem](https://github.com/TaroNukem)
