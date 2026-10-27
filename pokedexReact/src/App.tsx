import { Link, Routes, Route } from "react-router";
import Home from "./pages/Home";
import PokemonDetails from "./pages/PokemonDetails";
import Trainer from "./pages/Trainer";
import { Sun, Moon } from "lucide-react";
import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [dark, setDark] = useState(
    () => localStorage.getItem("theme") !== "light"
  );

  useEffect(() => {
    document.documentElement.classList.toggle("dark", dark);
    document.documentElement.setAttribute("data-theme", dark ? "dark" : "light");
    localStorage.setItem("theme", dark ? "dark" : "light");
  }, [dark]);

  return (
    <div>
      <nav>
        <div className="nav-links">
          <Link to={"/"}>Pokemon</Link>
          <Link to={"/treinadores"}>Treinadores</Link>
        </div>
        <button
          type="button"
          className="theme-btn"
          onClick={() => setDark((d) => !d)}
          aria-label="Mudar tema"
        >
          {dark ? <Sun size={18} /> : <Moon size={18} />}
          <span className="theme-btn__label">Mudar tema</span>
        </button>
      </nav>

      <Routes>
        <Route path={"/"} element={<Home />} />
        <Route path={"/treinadores"} element={<Trainer />} />
        <Route path={"/pokemon/:id"} element={<PokemonDetails />} />
      </Routes>
    </div>
  );
}

export default App;
