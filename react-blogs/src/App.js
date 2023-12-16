import { Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './pages/Home';
import Navbar from './components/Navbar';
import Blogs from './pages/Blogs';

function App() {
  return (
    <div>
      <Navbar />
      <div className="max-w-screen-xl justify-between mx-auto p-4">
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/blogs' element={<Blogs />} />
        </Routes>
      </div>
    </div>
  )
}

export default App;
