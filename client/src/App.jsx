import { Route, Routes } from 'react-router';
import Layout from './components/Layout/Layout';
import ModalTest from './pages/ModalTest';

import LoginPage from './pages/LoginPage';
import SignupPage from './pages/SignupPage';

import AskQuestion from './pages/AskQuestion';
import TopQuestion from './pages/TopQuestion';
import MyQuestion from './pages/MyQuestion';

import MyPage from './pages/MyPage';
import EditProfile from './pages/EditProfile';
import DeleteProfile from './pages/DeleteProfile';

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Layout />}>
          {/* 페이지 */}
          <Route path="/login" element={<LoginPage />} />
          <Route path="/signup" element={<SignupPage />} />
          <Route path="/askquestion" element={<AskQuestion />} />
          <Route path="/" element={<TopQuestion />} />
          <Route path="/question" element={<MyQuestion />} />
          <Route path="/modal" element={<ModalTest />} />
          <Route path="/mypage" element={<MyPage />} />
          <Route path="/editprofile" element={<EditProfile />} />
          <Route path="/deleteprofile" element={<DeleteProfile />} />
        </Route>
      </Routes>
    </>
  );
}

export default App;
