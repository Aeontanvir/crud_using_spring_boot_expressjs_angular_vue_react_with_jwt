import { Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './pages/Home';
import Navbar from './components/Navbar';

function App() {
  return (
    <div>
      <Navbar />
      <div className="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
        <Routes>
          <Route path='/' element={<Home />} />
        </Routes>
      </div>
    </div>
  )
}

export default App;
