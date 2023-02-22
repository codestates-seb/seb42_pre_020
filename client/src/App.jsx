import { Route, Routes } from 'react-router';
import Layout from './components/Layout/Layout';
import Modal from './components/UI/Modal/Modal';
import LoginPage from './pages/LoginPage';
import ModalTest from './pages/ModalTest';
import SignupPage from './pages/SignupPage';

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Layout />}>
          {/* 페이지 */}
          <Route path="/login" element={<LoginPage />} />
          <Route path="/signup" element={<SignupPage />} />
          <Route path="/modal" element={<ModalTest />} />
        </Route>
      </Routes>
    </>
  );
}

export default App;
