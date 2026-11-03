import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import  Home  from './pages/Home'
import  Votacao  from './pages/Votacao'
import  Resultado  from './pages/Resultado'
import  Header  from "./components/Header"

function App() {

  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/votacao" element={<Votacao />} />
        <Route path="/resultado" element={<Resultado />} />
      </Routes>
    </BrowserRouter>
  )

}

export default App
