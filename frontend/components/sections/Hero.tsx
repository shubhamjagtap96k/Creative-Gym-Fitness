"use client";

import { motion, useScroll, useTransform } from "framer-motion";
import { Button } from "@/components/ui/button";
import Link from "next/link";
import { ArrowRight } from "lucide-react";

export function Hero() {
    const { scrollY } = useScroll();
    const y1 = useTransform(scrollY, [0, 500], [0, 200]);
    const y2 = useTransform(scrollY, [0, 500], [0, -150]);

    return (
        <section className="relative min-h-screen flex items-center justify-center overflow-hidden pt-20">
            {/* Background with Glow */}
            <div className="absolute inset-0 bg-hero-glow opacity-60 dark:opacity-40 pointer-events-none" />

            {/* Floating Shapes Parallax */}
            <motion.div style={{ y: y1 }} className="absolute top-20 left-10 w-32 h-32 bg-primary/20 rounded-full blur-3xl" />
            <motion.div style={{ y: y2 }} className="absolute bottom-20 right-10 w-48 h-48 bg-secondary/20 rounded-full blur-3xl" />

            <div className="container px-4 text-center z-10 relative">
                <motion.div
                    initial={{ opacity: 0, y: 20 }}
                    animate={{ opacity: 1, y: 0 }}
                    transition={{ duration: 0.8 }}
                    className="space-y-6"
                >
                    <span className="inline-block py-1 px-3 rounded-full bg-primary/10 text-primary text-sm font-medium border border-primary/20 mb-4">
                        New Members Get 1st Week Free
                    </span>

                    <h1 className="text-5xl md:text-7xl font-extrabold tracking-tight">
                        Unlock Your <span className="text-transparent bg-clip-text bg-gradient-to-r from-primary to-secondary">Best Self</span>
                        <br /> at Creative Gym.
                    </h1>

                    <p className="max-w-2xl mx-auto text-lg md:text-xl text-muted-foreground">
                        Experience premium fitness with expert trainers, state-of-the-art equipment, and a community that pushes you further.
                    </p>

                    <div className="flex flex-col sm:flex-row gap-4 justify-center mt-8">
                        <Button size="lg" className="bg-primary hover:bg-primary/90 text-white shadow-lg shadow-primary/25 h-12 px-8 text-lg" asChild>
                            <Link href="/plans">
                                Request Enrollment <ArrowRight className="ml-2 w-5 h-5" />
                            </Link>
                        </Button>
                        <Button size="lg" variant="outline" className="border-primary/20 hover:bg-primary/5 h-12 px-8 text-lg" asChild>
                            <Link href="/classes">Explore Classes</Link>
                        </Button>
                    </div>
                </motion.div>
            </div>

            {/* Decorative Grid */}
            <div className="absolute inset-0 bg-[linear-gradient(to_right,#80808012_1px,transparent_1px),linear-gradient(to_bottom,#80808012_1px,transparent_1px)] bg-[size:24px_24px] pointer-events-none" />
        </section>
    );
}
