import { Route, Routes } from 'react-router';
import Layout from './components/Layout/Layout';
import AskQuestion from './pages/AskQuestion';
import LoginPage from './pages/LoginPage';
import SignupPage from './pages/SignupPage';

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Layout />}>
          {/* 페이지 */}
          <Route path="/login" element={<LoginPage />} />
          <Route path="/signup" element={<SignupPage />} />
          <Route path="/make" element={<AskQuestion />} />
        </Route>
      </Routes>
    </>
  );
}

export default App;
