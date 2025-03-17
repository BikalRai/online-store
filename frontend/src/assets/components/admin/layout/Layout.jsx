import Navbar from "../Navbar";

export default function Layout() {
  return (
    <div className="flex">
      <div className="min-h-dvh relative">
        <Navbar />
      </div>
      <main>
        content
        <section></section>
        <section></section>
      </main>
    </div>
  );
}
