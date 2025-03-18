import { LuBell } from "react-icons/lu";
import Avatar from "./Avatar";
import Navbar from "./Navbar";
import Search from "./Search";

export default function AdminLayout({ children }) {
  return (
    <div className="flex">
      <div className="relative min-h-dvh">
        <Navbar />
      </div>
      <main className="flex w-full flex-col p-5">
        <section className="flex flex-wrap items-center justify-between gap-3">
          <Search />
          <div className="flex items-center gap-3 text-2xl">
            {/* <LuBell className="cursor-pointer" /> */}
            <Avatar />
          </div>
        </section>
        <section className="mt-5 h-full">{children}</section>
      </main>
    </div>
  );
}
